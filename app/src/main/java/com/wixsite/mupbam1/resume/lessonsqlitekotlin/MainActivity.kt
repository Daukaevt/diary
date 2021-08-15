package com.wixsite.mupbam1.resume.lessonsqlitekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.wixsite.mupbam1.resume.lessonsqlitekotlin.databinding.ActivityMainBinding
import com.wixsite.mupbam1.resume.lessonsqlitekotlin.db.MyDbManager

class MainActivity : AppCompatActivity() {
    val myDbManager = MyDbManager(this)
    lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()

    }

    fun onClickNew (view: View) {
        val intent = Intent(this, EditActivity::class.java)
        startActivity(intent)

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}