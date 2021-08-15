package com.wixsite.mupbam1.resume.lessonsqlitekotlin.db

import android.provider.BaseColumns

object MyDbNameClass: BaseColumns {
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_Content = "content"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyLessonDb.db"
    const val CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS ${MyDbNameClass.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${MyDbNameClass.COLUMN_NAME_TITLE} TEXT," +
                "${MyDbNameClass.COLUMN_NAME_Content} TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${MyDbNameClass.TABLE_NAME}"



}