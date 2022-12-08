package com.example.appconsumoservicios.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appconsumoservicios.R


class MainActivity : AppCompatActivity() {
    lateinit var text : TextView
    lateinit var recyclre1 : RecyclerView
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text_hola)
        recyclre1 = findViewById(R.id.recyclerView2)
        //recyclre1.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)     //primero en configurar como sera el recycler
       // recyclre1.layoutManager = GridLayoutManager(this,2)     //primero en configurar como sera el recycler
        recyclre1.layoutManager = LinearLayoutManager(this)     //primero en configurar como sera el recycler
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.consumirServicio()
        viewModel.mutablePostList.observe(this, Observer {
            recyclre1.adapter = PostAdapter(it)
        })
        //test
    }



}

