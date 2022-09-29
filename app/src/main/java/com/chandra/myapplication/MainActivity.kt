package com.chandra.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        val login_btn = findViewById<Button>(R.id.login);
        val register_btn = findViewById<Button>(R.id.register);
        login_btn.setOnClickListener{
            val intet= Intent(this,Login::class.java)
            startActivity(intet)
        }

        register_btn.setOnClickListener{
            val intet= Intent(this,Register::class.java)
            startActivity(intet)
        }
    }
}