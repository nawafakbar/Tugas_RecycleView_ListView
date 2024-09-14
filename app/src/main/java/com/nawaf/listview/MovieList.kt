package com.nawaf.listview

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.nawaf.listview.adapter.FilmAdapter

class MovieList : AppCompatActivity() {

    // Sample image resource array
    private val imageList = arrayOf(
        R.drawable.hulk,
        R.drawable.avatar,
        R.drawable.batman,
        R.drawable.venom,
        R.drawable.end_game,
        R.drawable.spider_man
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        // Set up the GridView for photos
        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = FilmAdapter(this, imageList)
        gridView.adapter = adapter

        // Set up onClickListener for grid items
        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailFilm::class.java)
            intent.putExtra("imageResId", imageList[position]) // Pass the selected image ID to detail activity
            startActivity(intent)
        }

    }
}