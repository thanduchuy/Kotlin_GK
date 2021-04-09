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

class MainAdapter(var tinhs: ArrayList<Tinh>) :
    RecyclerView.Adapter<MainAdapter.myViewHolder>() {

    var listener: ((Tinh) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context)
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
            listener?.let { func -> func(hobby) }
        }

        holder.itemView.imageView3.setOnClickListener {
            tinhs.remove(hobby)
            notifyDataSetChanged()
        }
    }

    fun setOnClickItem(func: (Tinh) -> Unit) {
        listener = func
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