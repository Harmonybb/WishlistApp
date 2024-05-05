package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.net.HttpURLConnection

private val three_list= mutableListOf<Listing>()
private lateinit var rvList : RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize
        val rvList = findViewById<RecyclerView>(R.id.recyclerView)
        val wishAdp = WishlistAdapter(three_list)

        //create layout manager
        rvList.adapter= wishAdp
        rvList.layoutManager=LinearLayoutManager(this)


        val wishName = findViewById<EditText>(R.id.name)
        val wishPrice = findViewById<EditText>(R.id.price)
        val wishUrl = findViewById<EditText>(R.id.url)

        findViewById<Button>(R.id.button).setOnClickListener {
            val item : Listing = Listing(wishName.text.toString(), wishUrl.text.toString(), wishPrice.text.toString().toDouble())
            three_list.add(item)
            findViewById<EditText>(R.id.price).text.clear()
            findViewById<EditText>(R.id.name).text.clear()
            findViewById<EditText>(R.id.url).text.clear()
            wishAdp.notifyDataSetChanged()
        }
    }
}