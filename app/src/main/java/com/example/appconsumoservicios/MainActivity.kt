package com.example.appconsumoservicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var text : TextView
    lateinit var recyclre1 : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text_hola)
        recyclre1 = findViewById(R.id.recyclerView2)
        //recyclre1.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)     //primero en configurar como sera el recycler
       // recyclre1.layoutManager = GridLayoutManager(this,2)     //primero en configurar como sera el recycler
        recyclre1.layoutManager = LinearLayoutManager(this)     //primero en configurar como sera el recycler
        consumirServicio()
        //test
    }


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

        services.getPost().enqueue(object : Callback<List<PostModel>>{
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                println("Esta es la RESPUESTA")
                println(response.body().toString())
              recyclre1.adapter = PostAdapter(response.body()?: listOf()) //Aca el listado de lo que voy a mostrar
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                println("Este es un ERROR")
                println(t.message)

            }

        })

    }
}

