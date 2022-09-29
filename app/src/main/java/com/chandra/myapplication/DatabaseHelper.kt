package com.chandra.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context?):SQLiteOpenHelper(
    context,
    Constants.DB_NAME,
    null,
    Constants.DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(Constants.CREATE_LOGIN_TABLE)
        db!!.execSQL(Constants.CREATE_PASSWORD_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS"+Constants.LOGIN_TABLE_NAME)
        db!!.execSQL("DROP TABLE IF EXISTS"+Constants.PASSWORD_TABLE_NAME)
        onCreate(db)
    }
    fun insertRegistration(email:String,password:String): Long?{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.L_USERNAME,email)
        contentValues.put(Constants.L_PASSWORD,password)
        val success= db.insert(Constants.LOGIN_TABLE_NAME,null,contentValues)
        System.out.println("Record inserted successfully")
        db.close()
        return success
    }

    fun getRegistration(email:String):Int? {
        val db =this.writableDatabase
        val query="SELECT * FROM LOGIN_TABLE WHERE USERNAME=?"
       val success= db.rawQuery(query, arrayOf(email))
        //val success = db.rawQuery("SELECT * FROM LOGIN_TABLE WHERE L_USERNAME="+"["+email+"]",null)
        //val success1 = db.rawQuery("SELECT * FROM LOGIN_TABLE WHERE L_USERNAME= ?",new String[]{email});

        return success.count
    }

    fun loggingin(email:String,password:String): Int {
        val db = this.writableDatabase
        val query="SELECT * FROM LOGIN_TABLE WHERE USERNAME=? AND PASSWORD=?"
        val success=db.rawQuery(query, arrayOf(email,password))

        return success.count
    }

    fun insertPassword(application:String,password:String):Long?{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.P_APPLICATION,application)
        contentValues.put(Constants.P_PASSWORD,password)
        val success= db.insert(Constants.PASSWORD_TABLE_NAME,null,contentValues)
        db.close()
        return success
    }

    fun getAppPass(application:String): Int {
        val db = this.writableDatabase
        val query="SELECT * FROM PASSWORD_TABLE WHERE APPLICATION=?"
        val success=db.rawQuery(query, arrayOf(application))

        return success.count
    }

    fun updatePass(application:String,password:String){
        val db = this.writableDatabase
        val query= "UPDATE PASSWORD_TABLE SET PASSWORD='$password' WHERE APPLICATION='$application'"
        db.rawQuery(query,null)
        //val values = ContentValues()
        //values.put(Constants.P_PASSWORD,password)
        //db.update(Constants.PASSWORD_TABLE_NAME,values, "${Constants.P_APPLICATION} = $application", null)

    }

    fun updatePass1(application:String,password:String){
        val db = this.writableDatabase
        //val query= "UPDATE PASSWORD_TABLE SET PASSWORD="+password+" WHERE APPLICATION="+application+""
        //db.rawQuery(query,null)
        val values = ContentValues()
        values.put(Constants.P_PASSWORD,password)
        val wherecluse="${Constants.P_APPLICATION}=?"
        val whereargs = arrayOf(application.toString())
        db.update(Constants.PASSWORD_TABLE_NAME,values, wherecluse, whereargs)

    }

    @SuppressLint("Range")
    fun getAllAppPass(): ArrayList<PasswordModel>? {
        val data: ArrayList<PasswordModel> = ArrayList()
        val db = this.writableDatabase
        val query="SELECT * FROM PASSWORD_TABLE"
        val cursor=db.rawQuery(query,null)
        if(cursor.moveToFirst()){
            do{
                val model=PasswordModel()
                model.app=cursor.getString(cursor.getColumnIndex(Constants.P_APPLICATION))
                model.pass=cursor.getString(cursor.getColumnIndex(Constants.P_PASSWORD))
                data.add(model)
            }
                while (cursor.moveToNext())
        }
        return data


    }

    @SuppressLint("Range")
    fun getAllAppPass1(): HashMap<String, String>? {

            var app :String
            var pass:String

        val dataList: MutableList<PasswordModel> = ArrayList()
        val theMap = HashMap<String, String>()
        val db = this.writableDatabase
        val query="SELECT * FROM PASSWORD_TABLE"
        val cursor=db.rawQuery(query,null)
        if(cursor.moveToFirst()){
            do{
                val model=PasswordModel()
                app=cursor.getString(cursor.getColumnIndex(Constants.P_APPLICATION))
                pass=cursor.getString(cursor.getColumnIndex(Constants.P_PASSWORD))
                theMap.put(app,pass)
                dataList.add(model)
            }
            while (cursor.moveToNext())
        }
        return theMap


    }

    @SuppressLint("Range")
    fun getRegistrationData(): HashMap<String, String>? {

        var user :String
        var pass:String

        val dataList: MutableList<PasswordModel> = ArrayList()
        val theMap = HashMap<String, String>()
        val db = this.writableDatabase
        val query="SELECT * FROM LOGIN_TABLE"
        val cursor=db.rawQuery(query,null)
        if(cursor.moveToFirst()){
            do{
                val model=PasswordModel()
                user=cursor.getString(cursor.getColumnIndex(Constants.L_USERNAME))
                pass=cursor.getString(cursor.getColumnIndex(Constants.L_PASSWORD))
                theMap.put(user,pass)
                dataList.add(model)
            }
            while (cursor.moveToNext())
        }
        return theMap


    }


}
