package com.uz.taxation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.uz.taxation.fragments.UserForm
import com.uz.taxation.models.Model
import com.uz.taxation.models.form
import kotlinx.android.synthetic.main.activity_user.*


class UserActivity : AppCompatActivity(){

    val TAG = "UserActivity"

    //Connection to Firebase
    private lateinit var mDatabase: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        //Log the onCreate
        Log.d(TAG, "onCreate:SUCCESS")

        //variables that connects to firebase
        database = FirebaseDatabase.getInstance()
        mDatabase = database.getReference("Users")
        auth = FirebaseAuth.getInstance()

        val userId = auth.currentUser!!.uid
        val currentUserDb = mDatabase.child(userId).child("Applications")
        val arrayList = ArrayList<Model>()//Declare for list

        currentUserDb.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (child in dataSnapshot.children) {

                    child.ref.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                        override fun onDataChange(p0: DataSnapshot) {
                            val data = p0.getValue(form::class.java)

                            val title = data?.owner
                            val description = data?.location+" "+data?.barangay

                            arrayList.add(Model("$title ","$description",R.drawable.building_foreground))

                            val myAdapter = MyAdapter(arrayList, baseContext)

                            recyclerView.layoutManager = LinearLayoutManager(baseContext)
                            recyclerView.adapter = myAdapter
                        }


                    })
                }





            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        //End of list

        // Buttons when Click
       user_logout.setOnClickListener {
           signOut()
       }

        btn_addForm.setOnClickListener {
            val intent = Intent(this, UserForm::class.java)
            startActivity(intent)
        }
        back_btn.setOnClickListener {
            signOut()
        }
        //End of buttons


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