package com.example.app06_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app06_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // input 창 지우기 + 버튼 enabled function
        fun resetInputBtn() {
            binding.inputName.setText(null)
            binding.inputTel.setText(null)

            binding.updateBtn.isEnabled = false
            binding.deleteBtn.isEnabled = false
        }

        // Phone DataClass 가지는 리스트 phoneList
        val phoneList = mutableListOf<Phone>()
        for (i in 0..6) {
            // phoneList 데이터 추가
            phoneList.add(Phone("홍길동$i", "010-1111-111$i"))
        }

        // PhoneAdapter class 에 phoneList 연결
        val phoneAdapter = PhoneAdapter(phoneList)
        // 몇 번째 data 인지 저장할 position 변수 선언
        var position = 0
        // phoneAdapter 의 onItemClickLister interface 호출
        phoneAdapter.onItemClickLister = object:PhoneAdapter.OnItemClickLister{
            // PhoneAdapter interface override 하여 MainActivity 에서 구현
            override fun onItemClick(pos: Int) {
                // 사용자가 클릭한 list item 가져옴
                // position 변수에 pos 값 저장
                position = pos
                
                binding.inputName.setText(phoneList[pos].name)
                binding.inputTel.setText(phoneList[pos].tel)

                // 수정, 삭제 버튼 활성화
                binding.updateBtn.isEnabled = true
                binding.deleteBtn.isEnabled = true
            }

        }

        // recyclerview 에 phoneList 데이터 및 adapter 연결
        binding.phoneList.adapter = phoneAdapter
        // recyclerview 를 어떻게 출력할지 layout 설정
        binding.phoneList.layoutManager = LinearLayoutManager(this)

        // 추가
        binding.insertBtn.setOnClickListener {
            phoneAdapter.addItem(Phone(binding.inputName.text.toString(),
                binding.inputTel.text.toString()))

            resetInputBtn()
        }

        // 수정
        binding.updateBtn.setOnClickListener {
            phoneAdapter.updateItem(Phone(binding.inputName.text.toString(),
                binding.inputTel.text.toString()), position)
            
            resetInputBtn()
        }

        // 삭제
        binding.deleteBtn.setOnClickListener {
            phoneAdapter.deleteItem(position)
            
            resetInputBtn()
        }
    }
}