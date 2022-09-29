package com.chandra.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class PasswordManager : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_manager)
        val save_btn = findViewById<Button>(R.id.save)
        val app=findViewById<EditText>(R.id.application)
        val pass=findViewById<EditText>(R.id.password)

        save_btn.setOnClickListener {
            if (app.text.toString() != "" || pass.text.toString() != "") {
                if (dbHelper.getAppPass(app.text.toString()) > 0) {
                    this.showDialog("Error", "Application already exist please update the password")
                } else {
                    dbHelper.insertPassword(app.text.toString(), pass.text.toString())
                    app.setText("")
                    pass.setText("")
                    this.showDialog("Info", "Application and Password saved Successfully!")

                }
            }
            else{
                this.showDialog("Error", "All Fields are Mandatory")
            }
        }

        val update_btn = findViewById<Button>(R.id.update);
        update_btn.setOnClickListener{
            val intet= Intent(this,UpdatePassword::class.java)
            startActivity(intet)
        }
        val viewAll_btn = findViewById<Button>(R.id.viewAllPassword)
        viewAll_btn.setOnClickListener{
            val intet= Intent(this,AllPassword::class.java)
            startActivity(intet)
        }
    }

    private fun showDialog(title : String, Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.setPositiveButton("OK", null);
        builder.show()
    }
}