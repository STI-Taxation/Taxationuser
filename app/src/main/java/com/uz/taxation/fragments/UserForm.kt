package com.uz.taxation.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.uz.taxation.R
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.uz.taxation.UserActivity
import com.uz.taxation.models.User
import kotlinx.android.synthetic.main.activity_application.*


class UserForm : AppCompatActivity() {

    val TAG = "UserForm"

    //Connection to Firebase
    private lateinit var mDatabase: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)


        //variables that connects to firebase
        database = FirebaseDatabase.getInstance()
        mDatabase = database.reference.child("Users")
        auth = FirebaseAuth.getInstance()

        val userId = auth.currentUser!!.uid
        val currentUserDb = mDatabase.child(userId)

        // Read from the database
        currentUserDb.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val data = dataSnapshot.getValue(User::class.java)

                val fName = data?.firstName
                val lName = data?.lastName
                userName.setText(fName+" "+lName)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        btn_formSubmit.setOnClickListener {
            submitForm()
        }

        btn_back.setOnClickListener {
            onBackPressed()
        }


    }

    private fun submitForm() {
        if (!validateForm()) {
            return
        }

        // Add building Info
        Log.d(TAG, "submitForm:success")
        val userId = auth.currentUser!!.uid
        val currentUserDb = mDatabase.child(userId).child("Applications").push()
        currentUserDb.child("location").setValue(reg_location.text.toString())
        currentUserDb.child("street").setValue(reg_street.text.toString())
        currentUserDb.child("barangay").setValue(reg_brgy.text.toString())
        currentUserDb.child("owner").setValue(reg_owner.text.toString())
        currentUserDb.child("area").setValue(reg_Area.text.toString())
        currentUserDb.child("type").setValue(reg_Type.text.toString())
        currentUserDb.child("date").setValue(reg_Date.text.toString())
        currentUserDb.child("classification").setValue(reg_Classification.text.toString())
        currentUserDb.child("market").setValue(reg_Market.text.toString())
        currentUserDb.child("assessed").setValue(reg_Assessed.text.toString())

        //If success, display a message to the user
        Toast.makeText(this, "Registration Success.",
            Toast.LENGTH_SHORT).show()
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)

    }


    private fun validateForm(): Boolean {
        var valid = true

        val location = reg_location.text.toString()
        if (TextUtils.isEmpty(location)) {
            reg_location.error = "Required."
            valid = false
        } else {
            reg_location.error = null
        }

        val street = reg_street.text.toString()
        if (TextUtils.isEmpty(street)) {
            reg_street.error = "Required."
            valid = false
        } else {
            reg_street.error = null
        }

        val bgry = reg_brgy.text.toString()
        if (TextUtils.isEmpty(bgry)) {
            reg_brgy.error = "Required."
            valid = false
        }else{
            reg_brgy.error = null
        }

        val owner = reg_owner.text.toString()
        if (TextUtils.isEmpty(owner)) {
            reg_owner.error = "Required."
            valid = false
        } else {
            reg_owner.error = null
        }

        val area = reg_Area.text.toString()
        if (TextUtils.isEmpty(area)) {
            reg_Area.error = "Required."
            valid = false
        } else {
            reg_Area.error = null
        }

        val type = reg_Type.text.toString()
        if (TextUtils.isEmpty(type)) {
            reg_Type.error = "Required."
            valid = false
        } else {
            reg_Type.error = null
        }

        val date = reg_Date.text.toString()
        if (TextUtils.isEmpty(date)) {
            reg_Date.error = "Required."
            valid = false
        } else {
            reg_Date.error = null
        }

        val classification = reg_Classification.text.toString()
        if (TextUtils.isEmpty(classification)) {
            reg_Classification.error = "Required."
            valid = false
        } else {
            reg_Classification.error = null
        }

        val market = reg_Market.text.toString()
        if (TextUtils.isEmpty(market)) {
            reg_Market.error = "Required."
            valid = false
        } else {
            reg_Market.error = null
        }

        val assessed = reg_Assessed.text.toString()
        if (TextUtils.isEmpty(assessed)) {
            reg_Assessed.error = "Required."
            valid = false
        } else {
            reg_Assessed.error = null
        }

        return valid
    }


}