package com.example.app06

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app06.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 데이터 만들기
        var personList = mutableListOf<Person2>()
        for (i in 0..6) {
            personList.add(Person2("이름$i", "010-1111-111$i"))
        }
        // 어댑터 생성
        val personAdapter = Person2Adapter(personList)
        // 리사이클러뷰 어댑터 연결
        binding.personList.adapter = personAdapter
        // 레이아웃 설정
        binding.personList.layoutManager = LinearLayoutManager(this)

        // 전체보기
        binding.btnList.setOnClickListener {
            if (binding.personList.isVisible) {
                binding.personList.visibility = View.GONE
                binding.btnList.text = "전체보기"
            } else {
                binding.personList.visibility = View.VISIBLE
                binding.btnList.text = "숨기기"
            }
//            personAdapter.notifyDataSetChanged()
        }

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK) {
                val name = it.data?.getStringExtra("name").toString() ?: ""
                val tel = it.data?.getStringExtra("tel").toString() ?: ""

                personList.add(Person2(name, tel))
                personAdapter.notifyDataSetChanged()
            }
        }

        // 플러스 버튼
        binding.plusBtn.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity2_sub::class.java)
//            startActivity(intent)

            activityResult.launch(intent)
        }
    }
}