package com.nawaf.listview.adapter

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.media.RouteListingPreference
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nawaf.listview.ListPage2
import com.nawaf.listview.R
import com.nawaf.listview.adapter.MovieAdapter.MyViewHolder
import com.nawaf.listview.card_view_movie
import com.nawaf.listview.model.ModelBuku
import com.nawaf.listview.recycle_view

class BukuAdapter (private val buku: List<ModelBuku>):
    RecyclerView.Adapter<BukuAdapter.BukuAdapterHolder>() {

    //view holder yang digunakan unutk menyimpan referensi layout item
    class BukuAdapterHolder(view: View) : RecyclerView.ViewHolder(view){
        val txtJudul : TextView = view.findViewById(R.id.judulbuku)
        val txtPenulis : TextView = view.findViewById(R.id.penulis)
        val page : LinearLayout = view.findViewById(R.id.mainrecycle)
    }

    //membuat layout list item sebagai item dari recycle view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuAdapterHolder {

        val  view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return  BukuAdapterHolder(view)

    }

    //mengembalikan panjang nilai dari data
    override fun getItemCount() = buku.size

    //pengaturan data item pada setiap list dari recycle view
    override fun onBindViewHolder(holder: BukuAdapterHolder, position: Int) {
        val result = buku

        holder.txtPenulis.text = buku[position].penulis
        holder.txtJudul.text = buku[position].title

        holder.txtJudul.setOnClickListener {
            // Tangani klik item di sini
            Toast.makeText(holder.itemView.context, "Clicked: ${buku[position]}", Toast.LENGTH_SHORT).show()
        }

    }


    interface onAdapterListener {
        fun onClick(result: ModelBuku)
    }


    fun setData (data: List<ModelBuku>){
        notifyDataSetChanged()
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

}




