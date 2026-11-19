package com.example.pertemuan.Home.data.api

import com.example.pertemuan.Home.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}