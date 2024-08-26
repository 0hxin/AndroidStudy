package com.example.app08_1.recycler

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app08_1.R
import com.example.app08_1.databinding.ActivityMainBinding
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

        // adapter
        val pagerAdapter = CustomAdapter()
        // adapter 연결
        binding.viewPager.adapter = pagerAdapter

        val tabElement:List<String> = mutableListOf("Tab1", "Tab2", "Tab3", "Tab4")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            val textView = TextView(this@MainActivity)
            textView.text = tabElement[position]
            tab.customView = textView
        }.attach()
    }
}