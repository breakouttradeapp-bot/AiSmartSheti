package com.aisheti.sahayak.ui.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.aisheti.sahayak.databinding.ActivitySplashBinding
import com.aisheti.sahayak.ui.language.LanguageActivity
import com.aisheti.sahayak.ui.MainActivity
import com.aisheti.sahayak.utils.PreferencesManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startAnimationSequence()
    }

    private fun startAnimationSequence() {
        lifecycleScope.launch {
            // 1. Start Lottie plant-growing animation
            binding.lottieAnimation.apply {
                visibility = View.VISIBLE
                playAnimation()
            }

            delay(600)

            // 2. Fade in sun / background overlay
            ObjectAnimator.ofFloat(binding.sunOverlay, View.ALPHA, 0f, 1f).apply {
                duration = 800
                start()
            }

            delay(700)

            // 3. Floating leaf particles appear
            binding.leafParticles.visibility = View.VISIBLE
            ObjectAnimator.ofFloat(binding.leafParticles, View.ALPHA, 0f, 1f).apply {
                duration = 500
                start()
            }

            delay(500)

            // 4. Logo and text fade in with scale
            val logoFade = ObjectAnimator.ofFloat(binding.logoContainer, View.ALPHA, 0f, 1f)
            val logoScale = AnimatorSet().apply {
                playTogether(
                    ObjectAnimator.ofFloat(binding.logoContainer, View.SCALE_X, 0.5f, 1f),
                    ObjectAnimator.ofFloat(binding.logoContainer, View.SCALE_Y, 0.5f, 1f)
                )
                duration = 700
                interpolator = DecelerateInterpolator()
            }

            logoFade.duration = 700
            AnimatorSet().apply {
                playTogether(logoFade, logoScale)
                start()
            }
            binding.logoContainer.visibility = View.VISIBLE

            delay(400)

            // 5. Tagline slides up
            binding.taglineText.apply {
                visibility = View.VISIBLE
                translationY = 60f
                alpha = 0f
                animate()
                    .translationY(0f)
                    .alpha(1f)
                    .setDuration(500)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            }

            delay(800)

            // Navigate based on first launch
            navigateToNext()
        }
    }

    private suspend fun navigateToNext() {
        val isFirstLaunch = preferencesManager.isFirstLaunch.first()
        val nextActivity = if (isFirstLaunch) LanguageActivity::class.java else MainActivity::class.java
        startActivity(Intent(this@SplashActivity, nextActivity))
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
