package com.wixsite.mupbam1.resume.lessonsqlitekotlin.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.system.Os.close

class MyDbManager(context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db:SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title:String, content:String){
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_Content, content)
        }
        db?.insert(MyDbNameClass.TABLE_NAME,null,values)
    }
    fun readDbData():ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            MyDbNameClass.TABLE_NAME,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )
        with(cursor) {
            while (this?.moveToNext()!!) {
                val dataText =
                    cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText.toString())
            }
            cursor?.close()
            return dataList
        }
    }
    fun  closeDb(){
        myDbHelper.close()
    }

}