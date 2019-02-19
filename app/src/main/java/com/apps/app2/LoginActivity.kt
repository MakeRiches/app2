package com.apps.app2

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    var usuario: Usuario? = null
    var datosUsuario: DatosUsuario? = null
    var plataformaSeleccionada: String? = ""

    lateinit var adView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        this.inicializarFuenteTextos()


        this.cargarAnunciosBanner()

//        this.obtenerDatosIntroducidos()
    }

    /**
     * Establece la fuente personalizada a los textos.
     */
    private fun inicializarFuenteTextos() {
        var customFont = Typeface.createFromAsset(assets, "font/fortnite.ttf")

        val introducirUsuario = findViewById<TextView>(R.id.introducir_usuario_textView)
        val nombreUsuario = findViewById<EditText>(R.id.usuario_editText)

        val seleccionarPlataforma = findViewById<TextView>(R.id.seleccionar_plataforma_textView)
        val plataforma = findViewById<Spinner>(R.id.plataforma_spinner)

        introducirUsuario.typeface = customFont
        nombreUsuario.typeface = customFont
        seleccionarPlataforma.typeface = customFont
//        plataforma.typeface = customFont

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

    /**
     * Comprueba si existe un nombreUsuario para una plataforma.
     *
     * @param nombreUsuario Usuario a comprobar
     * @param plataforma Plataforma del nombreUsuario
     */
    fun comprobarUsuario(nombreUsuario: String, plataforma: String) {
        val call: Call<Usuario> = AppConfig.endpoints.getInformacionUsuario(nombreUsuario)

        call.enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(applicationContext, getString(R.string.error_api), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                val usuarioBody = response.body()

                if (usuarioBody?.error == null && usuarioBody?.platforms?.contains(plataforma) == true) {
                    usuario = response.body() as Usuario
                } else {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.error_comprobacion_usuario),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    /**
     * Obtiene las estadísticas del usuario
     *
     * @param uid Uid del usuario
     * @param plataforma Plataforma del usuario
     */
    fun getEstadisticasUsuario(uid: String?, plataforma: String) {
        val call: Call<DatosUsuario> =
            AppConfig.endpoints.getEstadisticasUsuario(uid, plataforma)

        call.enqueue(object : Callback<DatosUsuario> {
            override fun onFailure(call: Call<DatosUsuario>, t: Throwable) {
                Toast.makeText(applicationContext, getString(R.string.error_api), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DatosUsuario>, response: Response<DatosUsuario>) {
                datosUsuario = response.body() as DatosUsuario
            }
        })
    }

}
