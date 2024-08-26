package com.example.app08_viewpager.adapter

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.app08_viewpager.R
import com.example.app08_viewpager.databinding.ActivityMainBinding

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
        var list = mutableListOf<DataPage>(
            DataPage(Color.rgb(250, 234, 238), "1 Page"),
            DataPage(Color.rgb(250, 241, 238), "2 Page"),
            DataPage(Color.rgb(163, 182, 176), "3 Page"),
            DataPage(Color.rgb(223, 240, 215), "4 Page"),
            DataPage(Color.rgb(223, 230, 239), "5 Page"),
            DataPage(Color.rgb(157, 182, 239), "6 Page")
        )
        binding.viewPager2.adapter = ViewPagerAdapter(list)

        binding.btnToggle.setOnClickListener {
            when(binding.viewPager2.orientation) {
                ViewPager2.ORIENTATION_VERTICAL -> {
                    // 세로
                    binding.btnToggle.text = "가로로 슬라이드"
                    binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                }
                ViewPager2.ORIENTATION_HORIZONTAL -> {
                    // 가로
                    binding.btnToggle.text = "세로로 슬라이드"
                    binding.viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL
                }
            }
        }
    }
}