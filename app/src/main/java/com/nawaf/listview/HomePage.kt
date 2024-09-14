package com.nawaf.listview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {

    private lateinit var gas : Button
    private lateinit var gas2 : Button
    private lateinit var gas3 : Button
    private lateinit var gas4 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        gas = findViewById(R.id.btn1)
        gas2 = findViewById(R.id.btn2)
        gas3 = findViewById(R.id.btn3)
        gas4 = findViewById(R.id.btn4)


        gas.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        gas2.setOnClickListener(){
            val intent = Intent(this, recycle_view::class.java)
            startActivity(intent)
        }

        gas3.setOnClickListener(){
            val intent = Intent(this, Customimage_recycle::class.java)
            startActivity(intent)
        }

        gas4.setOnClickListener(){
            val intent = Intent(this, card_view_movie::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}