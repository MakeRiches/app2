package com.apps.app2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.google.android.gms.ads.MobileAds

class SplashActivity : AppCompatActivity() {

    val DURACION: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        this.inicializarAdmob()

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }, DURACION)

    }

    /**
     * Iniciliza AdMob.
     */
    private fun inicializarAdmob() {
        MobileAds.initialize(this, "ca-app-pub-1560403654736360~2809381388")
    }

}