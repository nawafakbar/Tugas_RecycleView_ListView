package com.nawaf.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListPage2 : AppCompatActivity() {

    private lateinit var lv_item : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_page2)

        lv_item = findViewById(R.id.listpage2)

        val getUsername = intent.getStringExtra("username")

        //bikin array list
        val namaBinatang = listOf("${getUsername}")

        //memasukan data array binatang ke adapter
        //android layout -->
        lv_item.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namaBinatang)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}