package com.uz.taxation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Application","New Application",R.drawable.building1))
        arrayList.add(Model("Application","New Application",R.drawable.building2))
        arrayList.add(Model("Application","New Application",R.drawable.building3))
        arrayList.add(Model("Application","New Application",R.drawable.building4))
        arrayList.add(Model("Application","New Application",R.drawable.building5))

        val myAdapter = MyAdapter(arrayList,this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter



    }
}
