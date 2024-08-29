package com.example.app09_db1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app09_db1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // sqliteHelper
        val sqliteHelper = SqliteHelper(this, "memo", 1)

        // adapter 생성
        val adapter = RecyclerAdapter()
        // RecyclerAdapter 안의 sqliteHelper 초기화
        adapter.helper = sqliteHelper
        // 전체보기 select * from memo
        // listData => RecyclerAdapter 안에 있는 변수
        adapter.listData.addAll(sqliteHelper.selectMemo())

        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)

        // 수정 시, 위치 값 저장할 position 변수
        // Long 타입 => Memo data class 의 num 변수가 Long 자료형
        var position:Long? = null

        // 버튼 클릭 이벤트
        binding.buttonSave.setOnClickListener {
            if (binding.editMemo.text.toString().isNotEmpty()) {
                if (binding.buttonSave.text.toString() == "저장") {
                    val memo = Memo(null, binding.editMemo.text.toString(), System.currentTimeMillis())
                    // sql 저장
                    sqliteHelper.insertMemo(memo)

                    // sql 저장 후 editText 값 비우기
                    binding.editMemo.setText(null)

                    adapter.listData.clear()
                    adapter.listData.addAll(sqliteHelper.selectMemo())
                    adapter.notifyDataSetChanged()
                }
                else {
                    val memo = Memo(position, binding.editMemo.text.toString(), System.currentTimeMillis())
                    sqliteHelper.updateMemo(memo)

                    binding.editMemo.setText(null)
                    // 버튼 다시 저장으로 바꾸기
                    binding.buttonSave.setText("저장")

                    adapter.listData.clear()
                    adapter.listData.addAll(sqliteHelper.selectMemo())
                    adapter.notifyDataSetChanged()
                }
            }
        }

        adapter.onItemClickLister = object:RecyclerAdapter.OnItemClickLister{
            override fun onItemClick(pos: Int) {
                position = adapter.listData[pos].num
                binding.editMemo.setText(adapter.listData[pos].content.toString())

                Log.d("sql position: ", position.toString())
                // 버튼 이름 변경
                binding.buttonSave.setText("수정")
            }

        }
    }
}