package com.nawaf.listview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nawaf.listview.DetailCustomImage
import com.nawaf.listview.HomePage
import com.nawaf.listview.ListPage2
import com.nawaf.listview.R
import com.nawaf.listview.model.ModelBuah

class BuahAdapter constructor(private val itemlist: ArrayList<ModelBuah>) :
    RecyclerView.Adapter<BuahAdapter.ModelViewHolder>() {

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //deklarasi widget dari item layout
        lateinit var ItemImage: ImageView
        lateinit var ItemText: TextView

        init {
            ItemImage = itemView.findViewById(R.id.gambar) as ImageView
            ItemText = itemView.findViewById(R.id.nama) as TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val nview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_custome_image, parent, false)
        return ModelViewHolder(nview)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.ItemImage.setImageResource(itemlist[position].image)
        holder.ItemText.setText(itemlist[position].deskripsi)

        holder.itemView.setOnClickListener {
            val a = holder.itemView.context
            val b = Intent(a, DetailCustomImage::class.java)
            b.putExtra("imageResId", itemlist[position].image)
            b.putExtra("des", itemlist[position].deskripsi)
            a.startActivity(b)
        }

    }

}