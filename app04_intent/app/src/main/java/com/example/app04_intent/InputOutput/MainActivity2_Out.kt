package com.example.app04_intent.InputOutput

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app04_intent.R
import com.example.app04_intent.databinding.Activity2OutBinding

class MainActivity2_Out : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity2_out)
        val binding = Activity2OutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 전달받은 intent  에서 값을 추출하여 출력
        var name = intent.getStringExtra("name").toString()
        var age = intent.getStringExtra("age").toString()
        var phone = intent.getStringExtra("phone").toString()
        binding.txtResult.text = "이름 : ${name}  나이 ${age}  전화 ${phone} "

    }
}