package com.chandra.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class Register : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val register_btn = findViewById<Button>(R.id.button)
        val login_btn= findViewById<Button>(R.id.button1)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val confirmPassword = findViewById<EditText>(R.id.confirmPassword)
        val regCheck = dbHelper.getRegistrationData()!!
        register_btn.setOnClickListener{
            if(email.text.toString()!="" || password.text.toString()!="" || confirmPassword.text.toString()!=""){
            if(password.text.toString()==confirmPassword.text.toString()) {
                //if(dbHelper.getRegistrationData()==null) {
                    dbHelper.insertRegistration(email.text.toString(), password.text.toString())
                    email.setText("")
                    password.setText("")
                    confirmPassword.setText("")
                    this.showDialog("Info", "Registration Successful PLease Login")
                    //val intet = Intent(this, Login::class.java)
                    //startActivity(intet)
                //}
                //else{
                    //this.showDialog("Error", "You h" +
                            //"ave already Registered in this device.Multiple Registration not allowed ")
                //}
             }

             else {
                this.showDialog("Error", "Password and Confirm Password should be same")
                //val intet1 = Intent(this, Register::class.java)
                //startActivity(intet1)
             }
             }
            else{
                this.showDialog("Error", "All Fields are Mandatory")
            }
        }

        login_btn.setOnClickListener{
            val intet = Intent(this, Login::class.java)
            startActivity(intet)
        }
    }
    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.setPositiveButton("OK", null);
        builder.show()
    }
}