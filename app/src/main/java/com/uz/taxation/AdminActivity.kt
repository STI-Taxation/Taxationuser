package com.uz.taxation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.activity_user.*

class AdminActivity : AppCompatActivity() {
    val rc: RecyclerView?=null


    val TAG = "AdminActivity"

    //Connection to Firebase
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val arrayList = ArrayList<AdminModel>()

        arrayList.add(AdminModel("Application List","Description",R.drawable.building1))
        arrayList.add(AdminModel("Application List","Description",R.drawable.building2))
        arrayList.add(AdminModel("Application List","Description",R.drawable.building3))
        arrayList.add(AdminModel("Application List","Description",R.drawable.building4))
        arrayList.add(AdminModel("Application List","Description",R.drawable.building5))


        val myAdminAdapter = MyAdminAdapter(arrayList,this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdminAdapter



        admin_logout.setOnClickListener({
            signOut()
        })
    }

    private fun signOut() {
        auth.signOut()
        updateUI(null)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {

        }else{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

}
