package com.example.appconsumoservicios

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val listPost : List<PostModel>) :RecyclerView.Adapter<PostAdapter.PostViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_my_viewholder,parent,false))
        //cual es la vista que deseo que se muestre en el recycler
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(listPost[position]) // conectar  datos y vista
    }

    override fun getItemCount(): Int {
        return listPost.size // el tamaño
    }


    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       val idText = itemView.findViewById<TextView>(R.id.idText)
       val idTitle = itemView.findViewById<TextView>(R.id.titleText)
       val idDescrip = itemView.findViewById<TextView>(R.id.descripText)

        fun bind(postModel: PostModel) {
            idText.text = postModel.id.toString()
            idTitle.text = postModel.title
            idDescrip.text = postModel.body
        }

    }
}


