package com.dzdoes.pwned

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface PwnedService {
    @Headers("User-Agent: Pwnd-For-android")

    @GET("v2/breachedaccount/{parameter}")
    fun getAllBraches(@Path("parameter") account:String): Call<List<Breach>>


}