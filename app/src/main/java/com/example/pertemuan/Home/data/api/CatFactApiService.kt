package com.example.pertemuan.Home.data.api

import com.example.pertemuan.Home.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}