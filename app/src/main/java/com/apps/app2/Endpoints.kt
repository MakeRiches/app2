package com.apps.app2


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoints {

    @GET("/prod09/users/id")
    fun getInformacionUsuario(@Query("username") usuario: String): Call<Usuario>

//    @GET("prod09/users/public/br_stats_v2?user_id=4735ce9132924caf8a5b17789b40f79c&platform=pc")
//    fun getEstadisticasUsuario(@Query("user_id") idUsuario: String, @Query("platform") plataforma: String)
}