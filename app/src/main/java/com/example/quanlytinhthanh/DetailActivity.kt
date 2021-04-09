package com.example.quanlytinhthanh

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class DetailActivity : AppCompatActivity() {
    val REQUEST_CODE = 100
    var id = 100
    var uriImage: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.show()
        val bundle: Bundle? = intent.extras
        bundle?.let {
            id = bundle.get("id").toString().toInt()
            imageView4.setImageURI(bundle.get("image") as Uri?)
            textView3.text = bundle.get("name").toString()
            textView2.text = bundle.get("population").toString()
            textView4.text = bundle.get("description").toString()
        }

        button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            uriImage = data?.data
            imageView4.setImageURI(data?.data) // handle chosen image
            for (element in Supplier.data) {
                if(element.id == id) {
                    val index = Supplier.data.indexOf(element)
                    var newData = element
                    newData.image = uriImage!!
                    setResult(2,Intent().apply {
                        putExtra("index",index)
                        putExtra("url",uriImage.toString())
                    })
                }
            }

        }
    }
}