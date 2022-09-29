package com.chandra.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class UpdatePassword : AppCompatActivity() {
     var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)

        val app = findViewById<EditText>(R.id.application)
        val password = findViewById<EditText>(R.id.password)
        val update_btn = findViewById<Button>(R.id.update);
        val allpass_btn= findViewById<Button>(R.id.viewAllPassword)
        update_btn.setOnClickListener{
            if(app.text.toString()!="" || password.text.toString()!="") {
                if (dbHelper.getAppPass(app.text.toString()) > 0) {
                    dbHelper.updatePass1(app.text.toString(), password.text.toString())
                    app.setText("")
                    password.setText("")
                    this.showDialog("Info", "Application Password Updated Successfully!")
                } else {
                    this.showDialog("Error", app.text.toString() + " Application does not Exist!")
                    password.setText("")
                }
            }
            else{
                this.showDialog("Error", "All Fields are Mandatory")
            }
        }
        allpass_btn.setOnClickListener{
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