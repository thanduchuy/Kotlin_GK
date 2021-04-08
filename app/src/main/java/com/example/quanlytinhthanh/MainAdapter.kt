package com.example.quanlytinhthanh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tinh_thanh.view.*

class MainAdapter(val context: Context, var tinhs: ArrayList<Tinh>) :
    RecyclerView.Adapter<MainAdapter.myViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(com.example.quanlytinhthanh.R.layout.tinh_thanh, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tinhs.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val hobby = tinhs[position]
        holder.setData(hobby, position)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id",tinhs[position].id)
            intent.putExtra("name", tinhs[position].name)
            intent.putExtra("population", tinhs[position].population)
            intent.putExtra("description", tinhs[position].description)
            intent.putExtra("image", tinhs[position].image)
            context?.startActivity(intent)
        }

        holder.itemView.imageView3.setOnClickListener {
            tinhs.remove(hobby)
            notifyDataSetChanged()
        }
    }

    inner class myViewHolder(myView: View) : RecyclerView.ViewHolder(myView) {

        init {
        }

        fun setData(rooms: Tinh?, position: Int) {
            itemView.imageView2.setImageURI(rooms!!.image)
            itemView.textView.text = rooms!!.name
        }
    }
}