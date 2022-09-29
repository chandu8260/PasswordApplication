package com.chandra.myapplication

object Constants {
    const val DB_NAME="PASSWORD_MANAGER"
    const val DB_VERSION=1
    const val LOGIN_TABLE_NAME="LOGIN_TABLE"
    const val L_ID="ID"
    const val L_USERNAME="USERNAME"
    const val L_PASSWORD="PASSWORD"
    const val L_ADD_TIMESTAMP="ADD_TIMESTAMP"
    const val L_UPDATED_TIMESTAMP="UPDATED_TIMESTAMP"

    const val CREATE_LOGIN_TABLE =("CREATE TABLE "+LOGIN_TABLE_NAME+"("
            + L_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + L_USERNAME+" TEXT,"
            + L_PASSWORD+" TEXT,"
            + L_ADD_TIMESTAMP+" TEXT,"
            + L_UPDATED_TIMESTAMP+" TEXT"
            +");")
    const val PASSWORD_TABLE_NAME="PASSWORD_TABLE"
    const val P_ID="ID"
    const val P_APPLICATION="APPLICATION"
    const val P_PASSWORD="PASSWORD"
    const val P_ADD_TIMESTAMP="ADD_TIMESTAMP"
    const val P_UPDATED_TIMESTAMP="UPDATED_TIMESTAMP"

    const val CREATE_PASSWORD_TABLE =("CREATE TABLE "+PASSWORD_TABLE_NAME+"("
            + P_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + P_APPLICATION+" TEXT,"
            + P_PASSWORD+" TEXT,"
            + P_ADD_TIMESTAMP+" TEXT,"
            + P_UPDATED_TIMESTAMP+" TEXT"
            +");")


}