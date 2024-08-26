package com.example.app04_intent.InputOutput

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app04_intent.R
import com.example.app04_intent.databinding.Activity2InputBinding

class MainActivity2_Input : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = Activity2InputBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  setContentView(R.layout.activity2_input)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnAdd.setOnClickListener {
            Log.d("name", "${binding.edtName.text}")
            intent.putExtra("name", binding.edtName.text.toString())
            intent.putExtra("age", binding.edtAge.text.toString())
            intent.putExtra("phone", binding.edtPhone.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}