package com.apps.app2

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class DatosActivity : AppCompatActivity() {

    lateinit var adView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        this.cargarAnunciosBanner()
    }

    /**
     * Carga los anuncios del banner.
     */
    private fun cargarAnunciosBanner() {
        adView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder()
            .addTestDevice("971E70F52A188292A6C04A6A5DD4D145")
            .build()
        adView.loadAd(adRequest)
    }

}