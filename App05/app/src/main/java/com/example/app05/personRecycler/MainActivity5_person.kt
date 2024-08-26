package com.example.app05.personRecycler

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app05.R
import com.example.app05.databinding.Activity5PersonBinding
import com.example.app05.databinding.CustomPersonBinding

class MainActivity5_person : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity5_person)
        val binding = Activity5PersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //1. 데이터 생성   ==>전체보기 버튼 이벤트에서 구현
        var personList = mutableListOf<Person5>()   // personList 아무 것도 없음

        //2. 어댑터 생성
        val personAdapter = PersonAdapter(personList)
        //3. 리사이클러뷰 와 어댑터 연결
        binding.recyclerView5.adapter = personAdapter
        //4. 리사이클러뷰 레이아웃 설정
        binding.recyclerView5.layoutManager = LinearLayoutManager(this)
        
        //전체보기  버튼 클릭
        binding.btnList.setOnClickListener {
            for(i in 0..6){
                personList.add(Person5("이순신$i", "010-1111-222$i"))
            }
            //binding.recyclerView5.adapter = personAdapter
            personAdapter.notifyDataSetChanged()
        }
        //추가(+) 버튼 클릭
        binding.floatingActionButton.setOnClickListener {
         val dialogPerson = CustomPersonBinding.inflate(layoutInflater)
         AlertDialog.Builder(this).run {
             setTitle("추가")
             setMessage("여기서 추가내용 입력하세요")
             setView(dialogPerson.root)
             setPositiveButton("확인", object:DialogInterface.OnClickListener {
                 override fun onClick(p0: DialogInterface?, p1: Int) {
                     personList.add(
                         Person5(dialogPerson.edtname.text.toString(),
                                           dialogPerson.edtphone.text.toString())
                     )
                   //  binding.recyclerView5.adapter = personAdapter
                     personAdapter.notifyDataSetChanged()
                 }
             })
             setNegativeButton("닫기", null)
             show()
         }
       }
    }
}