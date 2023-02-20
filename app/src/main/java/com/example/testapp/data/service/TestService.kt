package com.example.testapp.data.service

import com.example.testapp.data.model.Album
import retrofit2.http.GET
import retrofit2.http.Path

interface TestService {

    @GET("albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int): Album
}