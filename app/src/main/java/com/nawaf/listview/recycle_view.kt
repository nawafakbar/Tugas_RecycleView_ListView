package com.nawaf.listview

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nawaf.listview.adapter.BukuAdapter
import com.nawaf.listview.model.ModelBuku

class recycle_view : AppCompatActivity() {

    //view group --> bisa menampung data lebih banyak lebih cepat
    //recycle load data yg d layar aja
    private lateinit var  rv_buku : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)

        rv_buku = findViewById(R.id.rv_buku)

        //ini kita bikin array data
        val listBuku = listOf(
            ModelBuku(title = "Buku Atomic Habit", penulis = "Arhan Pratama"),
            ModelBuku(title = "Buku Filosofi Teras", penulis = "Hendri nawawing"),
            ModelBuku(title = "Buku Android Kotlin3 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Anak Anugrah", penulis = "Indra Jegel"),
            ModelBuku(title = "Buku Seni Bahagia", penulis = "Nawaf Akbar"),
        )

        val nBukuAdapter = BukuAdapter(listBuku)

        rv_buku.setOnClickListener(){
                val intent = Intent(this@recycle_view, MainActivity::class.java)
                startActivity(intent)
            }

        rv_buku.apply {
            layoutManager = LinearLayoutManager(this@recycle_view)
            adapter = nBukuAdapter
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pindah)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}