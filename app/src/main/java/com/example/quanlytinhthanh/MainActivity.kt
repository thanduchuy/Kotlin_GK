package com.example.quanlytinhthanh

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 100
    var uriImage: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bundle: Bundle? = intent.extras

        val layoutManager1 = GridLayoutManager(this, 2)
        layoutManager1.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager1
        var adapter = MainAdapter( Supplier.data)
        recyclerView.adapter = adapter
        adapter.setOnClickItem {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id",it.id)
            intent.putExtra("name", it.name)
            intent.putExtra("population", it.population)
            intent.putExtra("description", it.description)
            intent.putExtra("image", it.image)
            startActivityForResult(intent,REQUEST_CODE)
        }

        bundle?.let {
            adapter.notifyDataSetChanged()
        }

        button1.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE)
        }

        button.setOnClickListener {
            val newData = Tinh(Supplier.data.size+1,
                editTextTextPersonName.text.toString(),
                uriImage!!,
                editTextTextPersonName2.text.toString().toInt(),
                editTextTextPersonName3.text.toString())
            Supplier.data.add(newData)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            uriImage = data?.data
            imageView.setImageURI(data?.data) // handle chosen image
        }
        if (resultCode == 2){
            Log.e("data",data?.getStringExtra("url"))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_info -> Toast.makeText(this, "Ung dung TInh Thanh", Toast.LENGTH_LONG).show()
            R.id.nav_change -> recyclerView.setBackgroundColor(R.color.design_default_color_primary)
        }

        return super.onOptionsItemSelected(item)
    }
}