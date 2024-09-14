package com.nawaf.listview

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var lv_item : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lv_item = findViewById(R.id.binatang)


        //listview --> adaptre --> data sources

        //bikin array list
        val namaBinatang = listOf("Gajah", "Ular", "Beruang", "Ikan", "Sapi", "Kambing")

        //memasukan data array binatang ke adapter
        //android layout -->
        lv_item.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namaBinatang)

        lv_item.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    this@MainActivity,
                    "Anda memilih: " + namaBinatang[position],
                    Toast.LENGTH_SHORT
                ).show()

                var intent = Intent(this@MainActivity, ListPage2::class.java)
                val nUsername = namaBinatang[position]

                intent.putExtra("username", nUsername)
                print("Username : " + nUsername)
                startActivity(intent)
            }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}