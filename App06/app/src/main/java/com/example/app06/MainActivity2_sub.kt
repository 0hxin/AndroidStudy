package com.example.app06

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app06.databinding.Activity2SubBinding

class MainActivity2_sub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = Activity2SubBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity2_sub)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.insertBtn.setOnClickListener {
            intent.putExtra("name", binding.inputName.text.toString())
            intent.putExtra("tel", binding.inputTel.text.toString())

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}