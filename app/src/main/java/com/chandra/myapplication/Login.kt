package com.chandra.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class Login : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login_btn = findViewById<Button>(R.id.button);
        val reg_btn = findViewById<Button>(R.id.button1)
        login_btn.setOnClickListener{
            if(username.text.toString()!="" || password.text.toString()!="") {
                if (dbHelper.loggingin(
                        username.text.toString(),
                        password.text.toString()
                    ) > 0 && dbHelper.loggingin(
                        username.text.toString(),
                        password.text.toString()
                    ) != null
                ) {
                    val intent1 = Intent(this, PasswordManager::class.java)
                    startActivity(intent1)
                    username.setText("")
                    password.setText("")
                } else {
                    //val intent= Intent(this,Login::class.java)
                    //startActivity(intent)
                    this.showDialog(
                        "Error",
                        "Either Username/Password incorrect or The Account does not Exist!"
                    )
                }
            }
            else{
                this.showDialog("Error", "All Fields are Mandatory")
            }
        }
        reg_btn.setOnClickListener{
            val intent= Intent(this,Register::class.java)
            startActivity(intent)
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