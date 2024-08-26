package com.example.app08_1.fragment

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.app08_1.R
import com.example.app08_1.databinding.ActivityMain2Binding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fragAdapter:FragmentStateAdapter = fragAdapter(this)
        binding.viewPager.adapter = fragAdapter

        val tabElement:List<String> = mutableListOf("Tab1", "Tab2", "Tab3", "Tab4")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            val textView = TextView(this@MainActivity2)
            textView.text = tabElement[position]
            tab.customView = textView
        }.attach()
    }
}