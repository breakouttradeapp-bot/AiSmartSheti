require('dotenv').config();
const express = require('express');
const cors = require('cors');
const helmet = require('helmet');
const morgan = require('morgan');
const rateLimit = require('express-rate-limit');
const multer = require('multer');
const path = require('path');
const winston = require('winston');

const app = express();
const PORT = process.env.PORT || 3000;

// ─── Logger ───────────────────────────────────────────────────────────────────

const logger = winston.createLogger({
  level: 'info',
  format: winston.format.combine(
    winston.format.timestamp(),
    winston.format.json()
  ),
  transports: [
    new winston.transports.Console(),
    new winston.transports.File({ filename: 'logs/error.log', level: 'error' }),
    new winston.transports.File({ filename: 'logs/combined.log' })
  ]
});

// ─── Middleware ───────────────────────────────────────────────────────────────

app.use(helmet());
app.use(cors({ origin: '*' }));  // Restrict to your app in production
app.use(morgan('combined'));
app.use(express.json({ limit: '10mb' }));
app.use(express.urlencoded({ extended: true }));

// Rate limiting
const limiter = rateLimit({
  windowMs: parseInt(process.env.RATE_LIMIT_WINDOW_MS) || 15 * 60 * 1000,
  max: parseInt(process.env.RATE_LIMIT_MAX) || 100,
  standardHeaders: true,
  legacyHeaders: false,
  message: { success: false, response: 'Too many requests. Please try again later.' }
});
app.use(limiter);

// Multer for image uploads
const storage = multer.memoryStorage();
const upload = multer({
  storage,
  limits: { fileSize: 10 * 1024 * 1024 }, // 10MB
  fileFilter: (req, file, cb) => {
    const allowed = ['image/jpeg', 'image/jpg', 'image/png', 'image/webp'];
    if (allowed.includes(file.mimetype)) cb(null, true);
    else cb(new Error('Only image files allowed'));
  }
});

// ─── Cerebras AI Helper ───────────────────────────────────────────────────────

async function callCerebrasAI(messages, maxTokens = 800) {
  const response = await fetch(process.env.CEREBRAS_ENDPOINT, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${process.env.CEREBRAS_API_KEY}`
    },
    body: JSON.stringify({
      model: process.env.CEREBRAS_MODEL || 'gpt-oss-120b',
      max_tokens: maxTokens,
      messages
    })
  });

  if (!response.ok) {
    const errorText = await response.text();
    throw new Error(`Cerebras API error ${response.status}: ${errorText}`);
  }

  const data = await response.json();
  return data.choices[0]?.message?.content || '';
}

function getLanguageName(code) {
  const langs = {
    en: 'English', mr: 'Marathi', hi: 'Hindi', gu: 'Gujarati',
    pa: 'Punjabi', ta: 'Tamil', te: 'Telugu', kn: 'Kannada'
  };
  return langs[code] || 'English';
}

// ─── Routes ───────────────────────────────────────────────────────────────────

// Health check
app.get('/', (req, res) => {
  res.json({ status: 'ok', app: 'AI Sheti Sahayak Backend', version: '1.0.0' });
});

// POST /ask-ai — General AI farming advice
app.post('/ask-ai', async (req, res) => {
  try {
    const { message, language = 'en', type = 'general' } = req.body;
    if (!message?.trim()) {
      return res.status(400).json({ success: false, response: 'Message is required' });
    }

    const langName = getLanguageName(language);

    const systemPrompt = `You are an expert agriculture advisor helping Indian farmers.
Provide simple, practical, and accurate farming advice in ${langName}.
Keep responses concise (under 300 words), use bullet points where helpful.
Focus on: crop diseases, fertilizers, pest control, weather farming tips, soil improvement.
Always give actionable advice suitable for small and medium Indian farmers.`;

    const aiResponse = await callCerebrasAI([
      { role: 'system', content: systemPrompt },
      { role: 'user', content: message }
    ]);

    logger.info(`AI query processed: type=${type}, lang=${language}`);
    res.json({ success: true, response: aiResponse, language });

  } catch (error) {
    logger.error('ask-ai error:', error.message);
    res.status(500).json({
      success: false,
      response: 'AI service temporarily unavailable. Please try again.'
    });
  }
});

// POST /crop-disease — Analyze uploaded crop image
app.post('/crop-disease', upload.single('image'), async (req, res) => {
  try {
    if (!req.file) {
      return res.status(400).json({ success: false, response: 'Image is required' });
    }

    const language = req.body.language || 'en';
    const cropType = req.body.crop_type || 'unknown';
    const langName = getLanguageName(language);

    // Convert image to base64 for AI analysis
    const base64Image = req.file.buffer.toString('base64');
    const mimeType = req.file.mimetype;

    // Use AI with vision capabilities to analyze crop image
    const systemPrompt = `You are an expert plant pathologist and agricultural scientist.
Analyze the provided crop image and identify any diseases, pests, or problems.
Respond ONLY with a valid JSON object (no markdown, no code blocks) with this exact structure:
{
  "disease_name": "Name of disease or 'Healthy' if no disease found",
  "confidence": 0.85,
  "problem": "Description of the problem observed in ${langName}",
  "solution": "Step-by-step treatment in ${langName}",
  "spray_recommendation": "Specific spray/chemical recommendation in ${langName}",
  "prevention_tips": "Prevention advice in ${langName}"
}`;

    let aiText;
    try {
      // Try vision analysis first
      aiText = await callCerebrasAI([
        { role: 'system', content: systemPrompt },
        {
          role: 'user',
          content: [
            {
              type: 'image_url',
              image_url: { url: `data:${mimeType};base64,${base64Image}` }
            },
            {
              type: 'text',
              text: `Analyze this ${cropType} crop image for diseases or problems. Provide response in ${langName}.`
            }
          ]
        }
      ], 600);
    } catch (visionError) {
      // Fallback: text-based analysis
      logger.warn('Vision failed, using text fallback:', visionError.message);
      aiText = await callCerebrasAI([
        { role: 'system', content: systemPrompt },
        {
          role: 'user',
          content: `Provide common disease analysis for ${cropType} crop. Respond in ${langName} with the JSON structure.`
        }
      ], 600);
    }

    // Parse JSON response
    const cleanJson = aiText.replace(/```json\n?|\n?```/g, '').trim();
    let result;
    try {
      result = JSON.parse(cleanJson);
    } catch (parseError) {
      // Fallback structured response
      result = {
        disease_name: 'Analysis Complete',
        confidence: 0.70,
        problem: aiText.substring(0, 200),
        solution: 'Please consult your local agricultural officer for confirmation.',
        spray_recommendation: 'Contact local agriculture office for specific recommendations.',
        prevention_tips: 'Maintain proper irrigation, spacing and crop rotation.'
      };
    }

    logger.info(`Disease detection: crop=${cropType}, lang=${language}`);
    res.json({ success: true, ...result, language });

  } catch (error) {
    logger.error('crop-disease error:', error.message);
    res.status(500).json({
      success: false,
      response: 'Disease detection failed. Please try again.'
    });
  }
});

// GET /weather — Weather + AI farming advice
app.get('/weather', async (req, res) => {
  try {
    const { lat, lon, language = 'en' } = req.query;
    if (!lat || !lon) {
      return res.status(400).json({ success: false, response: 'Latitude and longitude required' });
    }

    // Fetch weather from OpenWeatherMap
    const weatherUrl = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${process.env.WEATHER_API_KEY}&units=metric`;
    const weatherResponse = await fetch(weatherUrl);

    if (!weatherResponse.ok) throw new Error('Weather API failed');
    const weather = await weatherResponse.json();

    // Also fetch forecast for rain prediction
    const forecastUrl = `https://api.openweathermap.org/data/2.5/forecast?lat=${lat}&lon=${lon}&appid=${process.env.WEATHER_API_KEY}&units=metric&cnt=8`;
    const forecastResponse = await fetch(forecastUrl);
    const forecast = await forecastResponse.json();

    const rainForecast = forecast.list?.some(item => item.rain || item.weather[0]?.main === 'Rain')
      ? 'Rain expected in next 24 hours'
      : 'No rain expected in next 24 hours';

    const langName = getLanguageName(language);
    const weatherSummary = `Temperature: ${weather.main.temp}°C, Humidity: ${weather.main.humidity}%, Wind: ${weather.wind.speed} km/h, Condition: ${weather.weather[0].description}. ${rainForecast}.`;

    // Get AI farming advice based on weather
    const advicePrompt = `Based on this weather: ${weatherSummary}
Give specific farming advice for Indian farmers in ${langName}.
Include: what crops to water, protect, or harvest. What farming activities to do today.
Keep advice under 150 words.`;

    const farmingAdvice = await callCerebrasAI([
      {
        role: 'system',
        content: `You are an expert agriculture advisor. Provide practical weather-based farming advice in ${langName}.`
      },
      { role: 'user', content: advicePrompt }
    ], 300);

    logger.info(`Weather fetched: lat=${lat}, lon=${lon}, lang=${language}`);
    res.json({
      success: true,
      location: weather.name || `${lat}, ${lon}`,
      temperature: weather.main.temp,
      feels_like: weather.main.feels_like,
      humidity: weather.main.humidity,
      wind_speed: weather.wind.speed,
      description: weather.weather[0].description,
      rain_forecast: rainForecast,
      ai_farming_advice: farmingAdvice,
      icon: weather.weather[0].icon
    });

  } catch (error) {
    logger.error('weather error:', error.message);
    res.status(500).json({
      success: false,
      response: 'Weather service unavailable. Check your internet connection.'
    });
  }
});

// POST /fertilizer — Fertilizer recommendations
app.post('/fertilizer', async (req, res) => {
  try {
    const { crop_type, soil_type, growth_stage, language = 'en' } = req.body;
    if (!crop_type || !soil_type || !growth_stage) {
      return res.status(400).json({ success: false, response: 'crop_type, soil_type, and growth_stage are required' });
    }

    const langName = getLanguageName(language);

    const prompt = `Crop: ${crop_type}, Soil: ${soil_type}, Stage: ${growth_stage}.
Provide fertilizer recommendations for Indian farmers.
Respond ONLY with a valid JSON object (no markdown, no code blocks):
{
  "crop": "${crop_type}",
  "stage": "${growth_stage}",
  "recommendations": [
    {"name": "Urea", "quantity": "20", "unit": "kg"},
    {"name": "DAP", "quantity": "10", "unit": "kg"}
  ],
  "application_method": "Method of application in ${langName}",
  "timing": "Best time to apply in ${langName}",
  "warnings": "Important precautions in ${langName}"
}`;

    const aiText = await callCerebrasAI([
      {
        role: 'system',
        content: `You are an expert Indian agricultural scientist. Provide precise fertilizer recommendations. Always respond with valid JSON only.`
      },
      { role: 'user', content: prompt }
    ], 500);

    const cleanJson = aiText.replace(/```json\n?|\n?```/g, '').trim();
    let result;
    try {
      result = JSON.parse(cleanJson);
    } catch {
      result = {
        crop: crop_type,
        stage: growth_stage,
        recommendations: [
          { name: 'Urea', quantity: '20', unit: 'kg' },
          { name: 'DAP', quantity: '10', unit: 'kg' }
        ],
        application_method: 'Mix thoroughly with soil near root zone',
        timing: 'Early morning or evening',
        warnings: 'Always water after application. Do not apply before heavy rain.'
      };
    }

    logger.info(`Fertilizer advice: crop=${crop_type}, stage=${growth_stage}`);
    res.json({ success: true, ...result });

  } catch (error) {
    logger.error('fertilizer error:', error.message);
    res.status(500).json({
      success: false,
      response: 'Fertilizer service unavailable. Please try again.'
    });
  }
});

// ─── Error Handling ───────────────────────────────────────────────────────────

app.use((err, req, res, next) => {
  logger.error('Unhandled error:', err.message);
  if (err.code === 'LIMIT_FILE_SIZE') {
    return res.status(413).json({ success: false, response: 'File too large. Maximum 10MB.' });
  }
  res.status(500).json({ success: false, response: 'Internal server error.' });
});

app.use('*', (req, res) => {
  res.status(404).json({ success: false, response: 'Endpoint not found.' });
});

// ─── Start ────────────────────────────────────────────────────────────────────

app.listen(PORT, () => {
  logger.info(`🌾 AI Sheti Sahayak Backend running on port ${PORT}`);
  logger.info(`Environment: ${process.env.NODE_ENV}`);
});

module.exports = app;
