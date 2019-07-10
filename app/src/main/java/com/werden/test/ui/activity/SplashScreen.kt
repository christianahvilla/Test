package com.werden.test.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.werden.test.R
import kotlinx.android.synthetic.main.activity_slpash_screen.*

class SplashScreen : AppCompatActivity() {

    private val mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slpash_screen)

        val ani = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        splashIcon.startAnimation(ani)
        splashText.startAnimation(ani)

        val monitor = Runnable {
            mHandler.postDelayed(startActivity(),2000)
        }
        monitor.run()
}

    private fun startActivity(): Runnable {
        return Runnable {
            val intent = Intent(this@SplashScreen, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}
