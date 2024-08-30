package com.example.app07.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app07.R
import com.example.app07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // lateinit : 변수를 미리 선언한 후, 초기화 후에 하겠다 알림
    // 초기화 미리 하지 않아도 변수 사용이 가능함
    lateinit var listFragment: ListFragment
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

        setFragment()
        binding.btnSend.setOnClickListener {
            listFragment.setValue("전달할 값")
        }
    }
    fun setFragment() {
        listFragment = ListFragment()
        var bundle = Bundle()
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 20240824)
        listFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, listFragment)
        transaction.commit()
    }
    fun goDetail(){
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }
    fun goBack() {
        onBackPressedDispatcher.onBackPressed()
    }
}