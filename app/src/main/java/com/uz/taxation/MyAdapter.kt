package com.uz.taxation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.uz.taxation.models.Model
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter (val arrayList: ArrayList<


        Model>, val context: Context):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(model: Model){
            itemView.titleTv.text = model.title
            itemView.descriptionTv.text = model.des
            itemView.imageTv.setImageResource(model.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener{
            if (position==0){
                Toast.makeText(context,"Item "+itemCount,Toast.LENGTH_SHORT).show()
            }
            if (position==1){
                Toast.makeText(context,"Item 2",Toast.LENGTH_SHORT).show()
            }
            if (position==2){
                Toast.makeText(context,"Item 3",Toast.LENGTH_SHORT).show()
            }
            if (position==3){
                Toast.makeText(context,"Item 4",Toast.LENGTH_SHORT).show()
            }
            if (position==4){
                Toast.makeText(context,"Item 5",Toast.LENGTH_SHORT).show()
            }
        }

    }
}