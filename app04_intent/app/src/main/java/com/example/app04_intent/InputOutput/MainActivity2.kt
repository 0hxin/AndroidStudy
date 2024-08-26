package com.example.app04_intent.InputOutput

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app04_intent.R
import com.example.app04_intent.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var name:String?= null
        var age:String ?= null
        var phone:String?= null

        //intent로 부터 리턴값 처리
        //매개변수 마지막이 람다함수 형식이면   소괄호 밖으로 뺄 수 있음
         val activityResultLauncher
             = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                if(it.resultCode == RESULT_OK){   // ?: 엘비스표현식
                     name =  it.data?.getStringExtra("name").toString() ?: ""
                     age =  it.data?.getStringExtra("age").toString() ?: ""
                     phone =  it.data?.getStringExtra("phone").toString() ?: ""
                     Log.d("phone : " , "${phone}")
                 }
        }
        //데이터입력 버튼 클릭  ===> 리턴값 있음
        binding.btnInsert.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity2_Input::class.java)
            //startActivity(intent)
            activityResultLauncher.launch(intent)
        }
        //데이터 출력 버튼 클릭 ===> 리턴값 없음
        binding.btnOutput.setOnClickListener {
            val intent = Intent(this, MainActivity2_Out::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("phone", phone)
            startActivity(intent)


        }
    }
}