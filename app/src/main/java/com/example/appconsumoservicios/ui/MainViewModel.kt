package com.example.appconsumoservicios.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appconsumoservicios.data.PostApiServices
import com.example.appconsumoservicios.data.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    val mutablePostList = MutableLiveData<List<PostModel>>()
    fun consumirServicio(){

        val retrofit = Retrofit.Builder() //Instancia para llamar servicio
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com").build()

        val services = retrofit.create(PostApiServices::class.java)
        /*services.getOnePost("1").enqueue(object : Callback<PostModel>{
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                println("Respuesta: ${response.body()?.id}" )
                text.text =response.body()?.title
            }

            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                println("Este es un ERROR")
            }

        })*/

        services.getPost().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                println("Esta es la RESPUESTA")
                println(response.body().toString())
                mutablePostList.postValue(response.body())
               //recyclre1.adapter = PostAdapter(response.body()?: listOf()) //Aca el listado de lo que voy a mostrar
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                println("Este es un ERROR")
                println(t.message)

            }

        })

    }
}