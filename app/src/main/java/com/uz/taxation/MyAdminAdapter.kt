package com.uz.taxation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.row.view.*
import kotlinx.android.synthetic.main.rowadmin.view.*

class MyAdminAdapter(val arrayList: ArrayList<AdminModel>,val context:Context) :
    RecyclerView.Adapter<MyAdminAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(model: AdminModel){
            itemView.tvtitle.text = model.tvtitle
            itemView.tvdesc.text = model.tvdesc
            itemView.imageadmin.setImageResource(model.imageadmin)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rowadmin,parent,false)
        return MyAdminAdapter.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bindItems(arrayList[position])


        holder.itemView.setOnClickListener{
            if(position==0){
                Toast.makeText(
                    context,"You Clicked",Toast.LENGTH_LONG
                ).show()
            }
            if(position==0){
                Toast.makeText(
                    context,"You Clicked",Toast.LENGTH_LONG
                ).show()
            }
            if(position==2){
                Toast.makeText(
                    context,"You Clicked",Toast.LENGTH_LONG
                ).show()
            }
            if(position==3){
                Toast.makeText(
                    context,"You Clicked",Toast.LENGTH_LONG
                ).show()
            }
            if(position==4){
                Toast.makeText(
                    context,"You Clicked",Toast.LENGTH_LONG
                ).show()
            }
        }

    }
}