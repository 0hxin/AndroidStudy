package com.example.app10_retrofit

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app10_retrofit.databinding.ActivityMainBinding
import com.example.app10_retrofit.databinding.CustomPhoneBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var phoneAdapter:PhoneAdapter? = null
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
        val phoneList = mutableListOf<Phone>()
        // adapter
        phoneAdapter = PhoneAdapter(phoneList)
        binding.recyclerView.adapter = phoneAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 전체 보기 버튼 이벤트
        // 전체 보기 버튼 클릭 시, RecyclerView 에 데이터 출력
        binding.btnList.setOnClickListener {
            PhoneClient.retrofit.findAll().enqueue(object : retrofit2.Callback<List<Phone>> {
                override fun onResponse(call: Call<List<Phone>>, response: Response<List<Phone>>) {
                    phoneAdapter!!.phoneList = response.body() as MutableList<Phone>
                    phoneAdapter?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<List<Phone>>, t: Throwable) {
                    Log.d("response fail", t.toString())
                }

            })
        }

        // 추가 버튼
        binding.floatBtn.setOnClickListener {
            val dialogPhone = CustomPhoneBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("추가")
                setMessage("여기서 추가 내용을 입력하세요.")
                setView(dialogPhone.root)
                setPositiveButton("추가", object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        val p = Phone(0, dialogPhone.edtName.text.toString(), dialogPhone.edtPhone.text.toString())
                        PhoneClient.retrofit.save(p).enqueue(object:retrofit2.Callback<Phone>{
                            override fun onResponse(call: Call<Phone>, response: Response<Phone>) {
                                Log.d("response", response.body().toString())
                                // null 이 아닐때 넣어라
                                response.body()?.let { it1 -> phoneAdapter!!.addItem(it1) }
                            }

                            override fun onFailure(call: Call<Phone>, t: Throwable) {
                                Log.d("response fail", t.toString())
                            }
                        })
                    }
                })
                setNegativeButton("닫기", null)
                show()
            }
        }
    }
}