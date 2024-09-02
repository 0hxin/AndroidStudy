package com.example.app10_member

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app10_member.databinding.ActivityMainUpdateBinding

class MainActivity_Update : AppCompatActivity() {
    lateinit var binding: ActivityMainUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 전달받은 값
        var name = intent.getStringExtra("name")
        var phone = intent.getStringExtra("phone")
        var email = intent.getStringExtra("email")

        binding.editName.setText(name)
        binding.editPhone.setText(phone)
        binding.editEmail.setText(email)

        // 수정
        binding.btnSave.setOnClickListener {
            name = binding.editName.text.toString()
            phone = binding.editPhone.text.toString()
            email = binding.editEmail.text.toString()

            intent.putExtra("name", name)
            intent.putExtra("phone", phone)
            intent.putExtra("email", email)

            setResult(RESULT_OK, intent)
            finish()
        }

        // 닫기
        binding.btnBack.setOnClickListener {
            setResult(RESULT_CANCELED, intent)
            finish()
        }
    }
}