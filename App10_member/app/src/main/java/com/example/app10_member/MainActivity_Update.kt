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

        val db = intent.getStringExtra("db")

        var name:String
        var phone:String
        var email:String

        if (db == "insert") {
            binding.textView.text = "회원정보 추가"
            binding.btnSave.text = "추가"
        }
        else {
            binding.textView.text = "회원정보 수정"
            binding.btnSave.text = "수정"

            // 전달받은 값
            name = intent.getStringExtra("name").toString()
            phone = intent.getStringExtra("phone").toString()
            email = intent.getStringExtra("email").toString()

            binding.editName.setText(name)
            binding.editPhone.setText(phone)
            binding.editEmail.setText(email)
        }

        // btn 클릭 시
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