package com.nawaf.listview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nawaf.listview.ListPage2
import com.nawaf.listview.R
import com.nawaf.listview.card_view_movie
import com.nawaf.listview.recycle_view
import com.nawaf.listview.model.ModelMovide

class MovieAdapter constructor(
    private val getActivity: card_view_movie,//untuk bisa d klik
    private val movieList: List<ModelMovide>,
    private val itemClickListener : (Int) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardView: CardView = itemView.findViewById(R.id.cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_card, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.txtMovie.text = movie.title
        holder.imgMovie.setImageResource(movie.image)

        holder.itemView.setOnClickListener {
            itemClickListener(position)
        }



        }
    }


