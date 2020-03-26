package com.uz.taxation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_admin_view.*
import kotlinx.android.synthetic.main.activity_login.*

class AdminView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_view)

        val actionBar : ActionBar? =supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")
        val aDescription = intent.getStringExtra("iDescription")
        val aImageView = intent.getIntExtra("iImageView",0)

        actionBar.setTitle(aTitle)
        a_title.text = aTitle
        location.text = aDescription
        imageView.setImageResource(aImageView)
    }
}
