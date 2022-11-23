package com.example.practice

import android.annotation.SuppressLint
import android.content.Intent
import java.io.FileInputStream
import java.io.FileOutputStream

import android.view.View
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var userID: String = "userID"
    lateinit var fname: String
    lateinit var str: String
    lateinit var calendarView: CalendarView
    lateinit var updateBtn: Button
    lateinit var deleteBtn:Button
    lateinit var saveBtn:Button
    lateinit var diaryTextView: TextView
    lateinit var diaryContent:TextView
    lateinit var title:TextView
    lateinit var contextEditText: EditText
    lateinit var goBtn: Button  // add
    lateinit var date: String   // add

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("ITM", "commit check")
        Log.d("ITM","Main in")

        // UI값 생성
        calendarView=findViewById(R.id.calendarView)
        title=findViewById(R.id.title)
        goBtn=findViewById(R.id.goBtn)  // add


        title.text = "If I Dieary"

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            Log.d("ITM","calendar in: $view, $year, $month, $dayOfMonth")
            date = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            Log.d("ITM","calendar in: date= $date")
        }

        goBtn.setOnClickListener {
            Log.d("ITM","gobtn in")
            val intent = Intent(this, FeelingActivity::class.java)
            intent.putExtra("date", date)
            startActivity(intent)
        }

    }
}