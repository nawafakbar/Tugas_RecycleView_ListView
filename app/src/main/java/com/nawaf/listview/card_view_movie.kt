package com.nawaf.listview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nawaf.listview.adapter.MovieAdapter
import com.nawaf.listview.model.ModelMovide

class card_view_movie : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var movieAdapter : MovieAdapter? = null
    private var movieList = mutableListOf<ModelMovide>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_view_movie)

        recyclerView = findViewById(R.id.card) as RecyclerView

        movieAdapter = MovieAdapter(this@card_view_movie, movieList) { position ->
            showDetailDialog(position)
        }

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this , 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = movieAdapter

        prepareMovieList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareMovieList() {
        var movie = ModelMovide("Ävatar", R.drawable.avatar)
        movieList.add(movie)

        var movie2 = ModelMovide("Batman", R.drawable.batman)
        movieList.add(movie2)

        var movie3 = ModelMovide("Hulk", R.drawable.hulk)
        movieList.add(movie3)

        var movie4 = ModelMovide("Jumanji", R.drawable.jumanji)
        movieList.add(movie4)

        var movie5 = ModelMovide("SpierMan", R.drawable.spider_man)
        movieList.add(movie5)

        var movie6 = ModelMovide("Avangers", R.drawable.end_game)
        movieList.add(movie6)

        var movie7 = ModelMovide("Venom", R.drawable.venom)
        movieList.add(movie7)

        var movie8 = ModelMovide("Jurassic", R.drawable.jurassic_world)
        movieList.add(movie8)

        movieAdapter!!.notifyDataSetChanged()

        }

    private fun showDetailDialog(position: Int){
        val intent = Intent(this, DetailMovie::class.java)
        intent.putExtra("ImageResId", movieList[position].image)
        intent.putExtra("title", movieList[position].title)
        startActivity(intent)
    }


}