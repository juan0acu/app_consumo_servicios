package com.example.appconsumoservicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        consumirServicio()
    }

    fun consumirServicio(){

        val retrofit = Retrofit.Builder() //Instancia para llamar servicio
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com").build()

        val services = retrofit.create(PostApiServices::class.java)
        services.getPost().enqueue(object : Callback<PostModel>{
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                println("Esta es la RESPUESTA")
                println(response.body().toString())
            }

            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                println("Este es un ERROR")
                println(t.message)

            }

        })
    }
}