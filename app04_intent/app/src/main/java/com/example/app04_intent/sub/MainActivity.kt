package com.example.app04_intent.sub

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app04_intent.R
import com.example.app04_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val launcher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val sum = it.data?.getIntExtra("sum",0)
                Toast.makeText(applicationContext, "합계 : $sum",Toast.LENGTH_SHORT ).show()
            }

        }
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivitySub::class.java)
            intent.putExtra("Num1", binding.edtNum1.text.toString().toInt())
            intent.putExtra("Num2", binding.edtNum2.text.toString().toInt())

            //startActivityForResult(intent,0);
            launcher.launch(intent)
        }
    }
}