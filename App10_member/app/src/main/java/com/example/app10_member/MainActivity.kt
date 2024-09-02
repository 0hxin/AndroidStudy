package com.example.app10_member

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app10_member.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

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

        // adapter
        val memberAdapter = MemberAdapter()

        // recyclerView 연결
        binding.recyclerView.adapter = memberAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        MemberClient.retrofit.findAll().enqueue(object:retrofit2.Callback<List<Member>>{
            override fun onResponse(call: Call<List<Member>>, response: Response<List<Member>>) {
                memberAdapter!!.memberList = response.body() as MutableList<Member>
                memberAdapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                Log.d("response fail", t.toString())
            }
        })

        // intent 리턴 값 처리
        var position = 0
        var id:Long? = null
        var insertName:String? = null
        var insertPhone:String? = null
        var insertEmail:String? = null

        var name:String? = null
        var phone:String? = null
        var email:String? = null


        // 추가 intent
        val activityInsert = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                insertName = it.data?.getStringExtra("name").toString()
                insertPhone = it.data?.getStringExtra("phone").toString()
                insertEmail = it.data?.getStringExtra("email").toString()

                Log.d("response insert data :", "${insertName} / ${insertPhone} / ${insertEmail}")

                val m = Member(0, insertName!!, insertPhone!!, insertEmail!!)
                MemberClient.retrofit.save(m).enqueue(object :retrofit2.Callback<Member>{
                    override fun onResponse(call: Call<Member>, response: Response<Member>) {
                        Log.d("response", response.body().toString())
                        // null 이 아닐때 넣어라
                        response.body()?.let { it1 -> memberAdapter!!.addItem(it1) }
                    }

                    override fun onFailure(call: Call<Member>, t: Throwable) {
                        Log.d("response fail", t.toString())
                    }
                })
            }
        }

        // 추가 버튼
        binding.pluseBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity_Insert::class.java)
            // startActivity(intent)
            activityInsert.launch(intent)
        }


        // 수정 intent 처리
        val activityUpdate = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                name = it.data?.getStringExtra("name").toString()
                phone = it.data?.getStringExtra("phone").toString()
                email = it.data?.getStringExtra("email").toString()

                Log.d("response update data :", "${name} / ${phone} / ${email}")

                val updatedMember = Member(id!!, name!!, phone!!, email!!)
                MemberClient.retrofit.update(id!!, updatedMember).enqueue(object:retrofit2.Callback<Member>{
                    override fun onResponse(call: Call<Member>, response: Response<Member>) {
                        Log.d("response update", response.body().toString())
                        memberAdapter.updateItem(position, updatedMember)
                    }

                    override fun onFailure(call: Call<Member>, t: Throwable) {
                        Log.d("response update fail", t.toString())
                    }

                })
            }
        }
        // 수정
        memberAdapter.onItemClickLister = object:MemberAdapter.OnItemClickLister{
            override fun onItemClick(pos: Int) {
                position = pos
                id = memberAdapter.memberList[pos].id

                val intent = Intent(this@MainActivity, MainActivity_Update::class.java)
                intent.putExtra("name", memberAdapter.memberList[pos].name)
                intent.putExtra("phone", memberAdapter.memberList[pos].phone)
                intent.putExtra("email", memberAdapter.memberList[pos].email)

                activityUpdate.launch(intent)
                Log.d("response pos", position.toString())
                Log.d("response id", id.toString())
            }
        }
    }
}