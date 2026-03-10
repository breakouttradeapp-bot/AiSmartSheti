# 🌾 AI Sheti Sahayak — Smart Farmer AI Assistant

A production-ready Android application that helps Indian farmers with crop disease detection, fertilizer guidance, weather-based farming tips, and AI consultation in 8 regional languages.

---

## 📱 Features

| Feature | Description |
|---|---|
| 📷 Crop Disease Scan | Take/upload crop photo → AI identifies disease + treatment |
| 🌦 Weather Advice | GPS-based weather + AI farming tips |
| 🌱 Fertilizer Guide | Crop/soil/stage inputs → AI fertilizer recommendations |
| 🎤 Voice AI Assistant | Speak in your language → AI answers |
| 🌐 8 Languages | Marathi, Hindi, English, Gujarati, Punjabi, Tamil, Telugu, Kannada |
| 📊 Scan History | All past queries saved locally |
| 💾 Saved Advice | Bookmark AI responses |
| 🔔 Push Notifications | Weather alerts via Firebase |
| 💰 AdMob Monetization | Banner + interstitial + rewarded ads |

---

## 🏗 Architecture

```
AIShetiSahayak/
├── app/src/main/java/com/aisheti/sahayak/
│   ├── ShetiApplication.kt          # App class (Hilt + Firebase + AdMob)
│   ├── data/
│   │   ├── api/
│   │   │   ├── ShetiApiService.kt   # Retrofit interface
│   │   │   └── NetworkModule.kt     # Hilt DI for network
│   │   ├── db/
│   │   │   └── ShetiDatabase.kt     # Room DB + DAOs
│   │   ├── models/
│   │   │   └── Models.kt            # Data classes
│   │   └── repository/
│   │       └── ShetiRepository.kt   # Single source of truth
│   ├── ui/
│   │   ├── splash/SplashActivity    # Lottie animated splash
│   │   ├── language/LanguageActivity # First launch language picker
│   │   ├── MainActivity             # Home with 4 feature cards
│   │   ├── disease/DiseaseActivity  # CameraX + disease detection
│   │   ├── weather/WeatherActivity  # GPS weather + AI advice
│   │   ├── fertilizer/FertilizerActivity # Crop/soil/stage → AI
│   │   ├── voice/VoiceActivity      # SpeechRecognizer + AI chat
│   │   └── history/HistoryActivity  # Local DB history viewer
│   ├── viewmodel/ViewModels.kt      # All ViewModels (Hilt)
│   └── utils/
│       ├── Resource.kt              # Sealed Resource + PreferencesManager
│       └── Utils.kt                 # AdManager, LocationHelper, FCM
└── backend/
    ├── server.js                    # Express API server
    ├── package.json
    └── .env.example
```

---

## 🚀 Setup Guide

### Step 1 — Prerequisites

- Android Studio Iguana or newer
- JDK 17
- Node.js 18+ (for backend)
- Google Firebase account
- Google AdMob account
- Cerebras AI API key (https://www.cerebras.ai)
- OpenWeatherMap API key (https://openweathermap.org/api)

---

### Step 2 — Firebase Setup

1. Go to [Firebase Console](https://console.firebase.google.com)
2. Create project → Add Android app
3. Package name: `com.aisheti.sahayak`
4. Download `google-services.json`
5. Place in `app/` directory
6. Enable: **Firestore**, **Crashlytics**, **Cloud Messaging**

---

### Step 3 — AdMob Setup

1. Go to [AdMob Console](https://apps.admob.com)
2. Create new app
3. Copy **App ID** and update `res/values/strings.xml`:
   ```xml
   <string name="admob_app_id">ca-app-pub-XXXX~XXXX</string>
   <string name="banner_ad_unit_id">ca-app-pub-XXXX/XXXX</string>
   <string name="interstitial_ad_unit_id">ca-app-pub-XXXX/XXXX</string>
   ```

---

### Step 4 — Backend Setup

```bash
cd backend
cp .env.example .env
# Edit .env with your API keys

npm install
npm start          # Production
npm run dev        # Development with auto-reload
```

**Required .env values:**
```
CEREBRAS_API_KEY=your_key_here
WEATHER_API_KEY=your_openweathermap_key
PORT=3000
```

**Backend Endpoints:**
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Health check |
| POST | `/ask-ai` | General AI farming advice |
| POST | `/crop-disease` | Crop image disease analysis |
| GET | `/weather?lat=&lon=` | Weather + AI farming advice |
| POST | `/fertilizer` | Fertilizer recommendations |

---

### Step 5 — Deploy Backend

**Recommended: Railway.app (free tier)**
```bash
# Install Railway CLI
npm install -g @railway/cli
railway login
railway new
railway add
railway up
```

Or **DigitalOcean App Platform** / **AWS EC2** / **Google Cloud Run**.

Copy your deployed URL and update `app/build.gradle.kts`:
```kotlin
buildConfigField("String", "BACKEND_BASE_URL", "\"https://your-deployed-url.com/\"")
```

---

### Step 6 — Lottie Animations

Download free Lottie animations from [LottieFiles.com](https://lottiefiles.com):

1. Search "plant growing" → download → rename `plant_growing.json` → place in `app/src/main/res/raw/`
2. Search "leaf particles" → download → rename `leaf_particles.json` → place in `app/src/main/res/raw/`

Recommended searches:
- "plant growth animation"
- "leaf particles nature"
- "agriculture farming"

---

### Step 7 — Build & Run

```bash
# In Android Studio:
# 1. Open the AIShetiSahayak folder
# 2. Sync Gradle
# 3. Run on device/emulator (API 24+)

# Generate Release APK:
# Build → Generate Signed Bundle/APK
# Select Release build type
```

---

### Step 8 — Fonts

Download [Poppins font](https://fonts.google.com/specimen/Poppins) from Google Fonts.

Place in `app/src/main/res/font/`:
- `poppins_regular.ttf`
- `poppins_bold.ttf`
- `poppins_medium.ttf`

---

## 🤖 AI Integration (Cerebras)

The app uses **Cerebras gpt-oss-120b** model via your backend (API key stays server-side).

**System prompt used:**
```
You are an expert agriculture advisor helping Indian farmers.
Provide simple and practical farming advice in the selected regional language.
```

**Supported query types:**
- `general` — Any farming question
- `disease` — Crop disease analysis
- `fertilizer` — Fertilizer recommendations
- `weather` — Weather-based advice

---

## 🌐 Multi-Language Support

| Language | Code | Native Script |
|----------|------|---------------|
| English | en | English |
| Marathi | mr | मराठी |
| Hindi | hi | हिंदी |
| Gujarati | gu | ગુજરાતી |
| Punjabi | pa | ਪੰਜਾਬੀ |
| Tamil | ta | தமிழ் |
| Telugu | te | తెలుగు |
| Kannada | kn | ಕನ್ನಡ |

Language is stored in DataStore and sent with every AI request.
AI responds in the selected language.

---

## 🏪 Google Play Publishing

### Pre-publish Checklist:

- [ ] Replace all test AdMob IDs with real IDs
- [ ] Add real `google-services.json`
- [ ] Set real backend URL in `build.gradle.kts`
- [ ] Create Privacy Policy page and host it online
- [ ] Update Privacy Policy URL in `strings.xml`
- [ ] Sign APK with release keystore (`Build → Generate Signed Bundle`)
- [ ] Complete Data Safety form in Play Console
- [ ] Test on minimum API 24 device
- [ ] Test in all 8 languages
- [ ] Test with no internet (offline fallback)
- [ ] Verify crash-free with Firebase Crashlytics

### Generate Signed AAB:
1. `Build → Generate Signed Bundle / APK`
2. Select `Android App Bundle`
3. Create/use existing keystore
4. Build type: `release`

---

## 📊 Tech Stack

**Android App:**
- Kotlin + Coroutines
- MVVM + LiveData + ViewModel
- Hilt Dependency Injection
- Room Database (local cache)
- Retrofit + OkHttp (networking)
- CameraX (camera)
- SpeechRecognizer (voice input)
- Lottie (animations)
- Material Design 3
- DataStore (preferences)
- Firebase (Crashlytics + FCM + Firestore)
- Google AdMob

**Backend:**
- Node.js + Express
- Cerebras AI API (gpt-oss-120b)
- OpenWeatherMap API
- Multer (image upload)
- Winston (logging)
- Rate limiting + Helmet (security)

---

## 📞 Support

For issues, open a GitHub issue or contact support.

**Privacy Policy:** https://your-website.com/privacy-policy

---

*Built for Indian farmers 🌾 — Empowering agriculture with AI*
