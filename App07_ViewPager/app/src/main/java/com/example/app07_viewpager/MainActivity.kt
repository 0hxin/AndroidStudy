package com.example.app07_viewpager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app07_viewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

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
        val fragmentList = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())

        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList

        // viewPager adapter 연결
        binding.viewPager.adapter = adapter

        val tabTitle = listOf<String>("A", "B", "C", "D")

        // tabLayout, viewPager 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, postion ->
            tab.text = tabTitle[postion]
        }.attach()
    }
}