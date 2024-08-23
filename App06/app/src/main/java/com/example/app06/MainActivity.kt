package com.example.app06

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app06.databinding.ActivityMainBinding
import com.example.app06.databinding.DialogPersonBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 데이터 생성
        var personList = mutableListOf<Person>()
        // 어댑터 생성
        val personAdapter = PersonAdapter(personList)
        // 리사이클러 뷰에 어댑터 연결
        binding.personList.adapter = personAdapter
        // 레이아웃 설정
        binding.personList.layoutManager = LinearLayoutManager(this)

        // 전체보기
        binding.btnList.setOnClickListener {
            for (i in 0..6) {
                personList.add(Person("이순신$i", "010-1111-222$i"))
            }
            // 리스트의 크기와 아이템이 모두 변경되는 경우 사용
            personAdapter.notifyDataSetChanged()
//            binding.personList.isVisible
        }

        // 추가 버튼
        binding.plusBtn.setOnClickListener{
            val dialogPerson = DialogPersonBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("추가")
                setMessage("이름과 전화번호를 입력하세요.")
                setView(dialogPerson.root)
                setPositiveButton("OK", object : DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        personList.add(Person(dialogPerson.inputName.text.toString(),
                            dialogPerson.inputTel.text.toString()))

                        personAdapter.notifyDataSetChanged()
                    }
                })
                setNegativeButton("Cancel", null);
                show()
            }
        }
    }
}