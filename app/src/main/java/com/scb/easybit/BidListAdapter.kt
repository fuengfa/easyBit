package com.scb.easybit

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BidListAdapter : RecyclerView.Adapter<BidListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BidListViewHolder(parent)


    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: BidListViewHolder, position: Int) {

    }

    fun submitlist(hello: )

}

class BidListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(
            R.layout.listbid,
            parent, false)
){
    private var imageProduct1: ImageView? = null
    private var imageProduct2: ImageView? = null
    private var productName1: TextView? = null
    private var productName2: TextView? = null

    fun bind(){

        imageProduct1 = itemView.findViewById(R.id.img1)
        imageProduct2 = itemView.findViewById(R.id.img2)
        productName1 = itemView.findViewById(R.id.productName1)
        productName2 = itemView.findViewById(R.id.productName2)

        imageProduct1.let {
            Glide.with(itemView.context)
                .load(R.drawable.p1)
                .centerCrop()
                .into(it!!)
        }

        imageProduct2.let {
            Glide.with(itemView.context)
                .load(R.drawable.p2)
                .centerCrop()
                .into(it!!)
        }

    }

    }