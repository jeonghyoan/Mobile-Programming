package com.example.practice

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.practice.databinding.ActivityFeelingBinding
import com.example.practice.databinding.ActivityMainBinding

class FeelingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFeelingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myList =listOf("feeling1", "feeling2", "feeling3", "feeling4", "feeling5")

        val date = intent.getStringExtra("date")


        val myAdapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, myList)
        binding.spinner.adapter = myAdapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> {
                        binding.imageView.setImageResource(R.drawable.btn_minus)
                        var image = R.drawable.btn_minus
                    }
                    1 -> {
                        binding.imageView.setImageResource(R.drawable.btn_plus)
                        var image = R.drawable.btn_plus
                    }
                    2 -> {
                        binding.imageView.setImageResource(R.drawable.btn_star)
                        var image = R.drawable.btn_star
                    }
                    3 -> {
                        binding.imageView.setImageResource(R.drawable.btn_dialog)
                        var image = R.drawable.btn_dialog
                    }
                    4 -> {
                        binding.imageView.setImageResource(R.drawable.btn_dropdown)
                        var image = R.drawable.btn_dropdown
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        binding.goBtn2.setOnClickListener {
            val intent = Intent(this, SubActivity2::class.java)
            intent.putExtra("date", date)
            startActivity(intent)
        }
    }
}