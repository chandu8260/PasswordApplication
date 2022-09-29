package com.chandra.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TableLayout
import java.security.KeyStore

class AllPassword : AppCompatActivity() {
    var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_password)



        val arrayAdapter: ArrayAdapter<*>

        var arr = dbHelper.getAllAppPass1()
        //for(entry in theMap.entries.iterator())
        val users = arrayOf(

            dbHelper.getAllAppPass1().toString()
        )
        var mListView = findViewById<ListView>(R.id.listVIew)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter





    }
}