package com.apps.app2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.getInfo()
    }

    fun getInfo() {
        val call: Call<Usuario> = AppConfig.endpoints.getInformacionUsuario("TheTwiafasdfasdfn13")

        call.enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(applicationContext, "Falla", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                val usuario = response.body()
                println(usuario.toString())
            }

        })
    }


}
