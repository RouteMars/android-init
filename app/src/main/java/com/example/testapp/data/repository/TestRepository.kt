package com.example.testapp.data.repository

import com.example.testapp.common.ResultData
import com.example.testapp.data.model.Album
import com.example.testapp.data.service.TestService

class TestRepository constructor(private val service: TestService) {

    suspend fun getAlbum(id: Int): ResultData<Album> {
        val result = try {
            service.getAlbum(id)
        } catch (e: Exception) {
            return ResultData.Error("error == ${e.localizedMessage}")
        }
        return ResultData.Success(result)
    }
}