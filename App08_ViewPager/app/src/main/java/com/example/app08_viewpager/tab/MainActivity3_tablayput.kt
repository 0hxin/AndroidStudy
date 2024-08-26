package com.example.app08_viewpager.tab

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentActivity
import com.example.app08_viewpager.R
import com.example.app08_viewpager.databinding.ActivityMain3TablayputBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity3_tablayput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMain3TablayputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // adapter
        val contentPagerAdapter = ContentAdapter(this)
        // adapter 연결
        binding.viewPager.adapter = contentPagerAdapter

        val tabElement:List<String> = mutableListOf("Tab1", "Tab2", "Tab3")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val textView = TextView(this@MainActivity3_tablayput)
            textView.text = tabElement[position]
            tab.customView = textView
        }.attach()
    }
}