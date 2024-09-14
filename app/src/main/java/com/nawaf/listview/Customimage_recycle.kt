package com.nawaf.listview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.utils.widget.MockView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nawaf.listview.adapter.BuahAdapter
import com.nawaf.listview.model.MockList
import com.nawaf.listview.model.ModelBuah

class Customimage_recycle : AppCompatActivity() {

    private lateinit var rv_buah: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_customimage_recycle)
        rv_buah = findViewById(R.id.rv_data)

        rv_buah.layoutManager = GridLayoutManager(this, 1,
            GridLayoutManager.VERTICAL, false)

        val adapter = BuahAdapter(MockList.getModel() as ArrayList<ModelBuah>)
        rv_buah.adapter = adapter


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}