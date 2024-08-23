package com.example.app04_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app04_intent.databinding.ActivityMainSubBinding

class MainActivitySub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
      //  setContentView(R.layout.activity_main_sub)
        val binding = ActivityMainSubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val num1 = intent.getIntExtra("Num1", 0)
        val num2 = intent.getIntExtra("Num2", 0)
        val sum = num1 + num2

        binding.btnBack.setOnClickListener {
            val intent1 = Intent( applicationContext,  MainActivity::class.java   )
            intent1.putExtra("sum", sum)
            setResult(RESULT_OK, intent1)
            finish()
        }
    }
}