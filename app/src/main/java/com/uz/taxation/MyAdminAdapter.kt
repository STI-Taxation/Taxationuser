package com.uz.taxation

import android.content.Context
import android.content.Intent
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
            val model = arrayList.get(position)
            var gTitle :String = model.tvtitle
            var gDescription:String = model.tvdesc

            var gImageView: Int = model.imageadmin

            val intent = Intent(context,AdminView::class.java)

            intent.putExtra("iTitle",gTitle)
            intent.putExtra("iDescription",gDescription)
            intent.putExtra("iImageView",gImageView)

            context.startActivity(intent)
        }

    }
}