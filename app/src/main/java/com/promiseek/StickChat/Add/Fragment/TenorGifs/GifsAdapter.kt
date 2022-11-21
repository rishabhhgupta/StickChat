package com.promiseek.StickChat.Add.Fragment.TenorGifs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.promiseek.StickChat.R
import com.bumptech.glide.Glide
import com.promiseek.StickChat.Add.GetSelectedItemFromFragment


class GifsAdapter( var context: Context, var lastIndex: LastIndex,var getSelectedItemFromFragment: GetSelectedItemFromFragment): RecyclerView.Adapter<GifsViewHolder>() {

    lateinit var adapterPogoArrayList: ArrayList<AdapterPogo>
    init {
        adapterPogoArrayList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.tenor_gifs_items, parent, false)
        return GifsViewHolder(view)
    }

    override fun onBindViewHolder(holder: GifsViewHolder, position: Int) {
        Glide.with(context).asGif().load(adapterPogoArrayList.get(position).previewGifs).into(holder.imageView);
        if(adapterPogoArrayList.size-1 == position){
            lastIndex.get()
        }

        holder.imageView.setOnClickListener {
            adapterPogoArrayList.get(position).actualGifs?.let { it1 ->
                getSelectedItemFromFragment.GetGifs(
                    it1
                )
            }
        }



    }

    override fun getItemCount(): Int {
        return adapterPogoArrayList.size
    }


    fun addItems(adapterPogoArrayList: ArrayList<AdapterPogo>){
        adapterPogoArrayList.forEach {
            this.adapterPogoArrayList.add(it)
        }
        notifyDataSetChanged()

    }


}

class GifsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    lateinit var imageView:ImageView
    init {
        imageView = view.findViewById<ImageView>(R.id.itemImage)
    }
}

interface LastIndex{
    fun get()

}


