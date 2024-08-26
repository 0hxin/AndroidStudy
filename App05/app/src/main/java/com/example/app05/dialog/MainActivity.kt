package com.example.app05.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app05.R
import com.example.app05.databinding.ActivityMainBinding
import com.example.app05.databinding.DialogInputBinding

//p286
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // list Dialog
        binding.button.setOnClickListener {
            val items = arrayOf("사과", "복숭아", "수박")
            AlertDialog.Builder(this).run{
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true,false,true),
                    object:DialogInterface.OnMultiChoiceClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                            Log.d("MultiChoiceItems",
                                "${items[which]}  ${ if(isChecked) "선택되었습니다" else "선택 해제되었습니다." }")
                        }
                    }
                ) //setMultiChoiceItems
                setPositiveButton("닫기", null)
                show()
            } //run
        }// button



        //custom dialog
        binding.button2.setOnClickListener {
          val dialogBinding =  DialogInputBinding.inflate(layoutInflater)
            //라디오그룹 선택
            var txt =""
            dialogBinding.rdoGroup.setOnCheckedChangeListener { radioGroup, i ->
                if(i == dialogBinding.rdoM.id) txt = "남자"
                else txt="여자"
                dialogBinding.edtTxt.setText("$txt")
            }
            AlertDialog.Builder(this).run {
                setTitle("custom")
                setView(dialogBinding.root)
                setNegativeButton("취소",  null)
                setPositiveButton("확인",object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                       Log.d("custom", "${txt} 선택")
                    }
                })
                show()

            }

        }
    }
}