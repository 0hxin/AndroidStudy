package com.example.app07

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.app07.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.songBtn.setOnClickListener {
            val songFragment = Fragment_Song()
            fragmentLayout(songFragment)
        }

        binding.artistBtn.setOnClickListener {
            val artistFragment = Fragment_Artist()
            fragmentLayout(artistFragment)
        }

        binding.albumBtn.setOnClickListener {
            val albumFragment = Fragment_Album()
            fragmentLayout(albumFragment)
        }

        with(binding) {
            val listener = ClickHandler()
            songBtn2.setOnClickListener(listener)
            artistBtn2.setOnClickListener(listener)
            albumBtn2.setOnClickListener(listener)
        }

    }
    fun fragmentLayout(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

    inner class ClickHandler(): View.OnClickListener{
        var fr:Fragment? = null
        override fun onClick(v: View?) {
           when(v!!.id) {
               binding.songBtn2.id -> fr = Fragment_Song()
               binding.artistBtn2.id -> fr = Fragment_Artist()
               binding.albumBtn2.id -> fr = Fragment_Album()
           }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout2, fr!!)
                .addToBackStack(null)
                .commit()
        }
    }
}