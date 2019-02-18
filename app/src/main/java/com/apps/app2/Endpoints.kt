package com.apps.app2


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {

    @GET("/prod09/users/id")
    fun getInformacionUsuario(@Query("username") usuario: String): Call<Usuario>

    @GET("prod09/users/public/br_stats_v2")
    fun getEstadisticasUsuario(@Query("user_id") idUsuario: String?, @Query("platform") plataforma: String): Call<DatosUsuario>

}