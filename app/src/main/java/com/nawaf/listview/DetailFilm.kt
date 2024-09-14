package com.nawaf.listview

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DetailFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        // Get the image resource ID passed from the previous activity
        val imageResId = intent.getIntExtra("imageResId", 0)

        // Set the image to the ImageView
        val imageView = findViewById<ImageView>(R.id.imageViewDetail)
        imageView.setImageResource(imageResId)

    }
}