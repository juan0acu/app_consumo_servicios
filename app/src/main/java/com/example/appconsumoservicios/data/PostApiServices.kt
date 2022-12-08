package com.example.appconsumoservicios.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiServices {
    @GET("/posts") //llamo el listado
    fun getPost(): Call<List<PostModel>>

    @GET("/posts/{postId}") //llamo a uno solo
    fun getOnePost(@Path("postId")postId:String): Call<PostModel>
}