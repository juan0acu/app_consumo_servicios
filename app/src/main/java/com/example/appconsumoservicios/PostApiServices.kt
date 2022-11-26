package com.example.appconsumoservicios

import retrofit2.Call
import retrofit2.http.GET

interface PostApiServices {
    @GET("/posts")
    fun getPost(): Call<List<PostModel>>



}