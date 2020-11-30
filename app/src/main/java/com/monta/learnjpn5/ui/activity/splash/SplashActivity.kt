package com.monta.learnjpn5.ui.activity.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.monta.learnjpn5.ui.activity.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({ goToMain() }, 500)
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}