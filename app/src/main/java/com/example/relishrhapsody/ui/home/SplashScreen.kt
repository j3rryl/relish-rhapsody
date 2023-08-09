package com.example.relishrhapsody.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.relishrhapsody.MainActivity
import com.example.relishrhapsody.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val decorView: View = window.decorView
        val uiOptions: Int = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.setDisplayShowTitleEnabled(false)

        decorView.setSystemUiVisibility(uiOptions)
        val lottieAnimationView: LottieAnimationView = findViewById(R.id.lottie_cook)

        val temp = convertDpToPixels(this, 100)

        val radarRecipe: TextView = findViewById(R.id.radar_recipe)

        radarRecipe.animate().translationY(-temp).setDuration(1200).startDelay = 0

        Handler().postDelayed({
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 5500)

    }
    fun convertDpToPixels(context: Context, dp: Int): Float {
        return dp * context.resources.displayMetrics.density
    }
}