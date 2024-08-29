package com.example.ap09_db.diary

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ap09_db.R
import com.example.ap09_db.databinding.ActivityMain2Binding
import java.util.Calendar

class MainActivity2 : AppCompatActivity() {
    // lateinit : 초기화 나중에, 선언은 먼저
    lateinit var binding:ActivityMain2Binding
    lateinit var sqLiteDatabase:SQLiteDatabase
    lateinit var myDBHelper:MyDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myDBHelper = MyDBHelper(this)

        // db 설정
        sqLiteDatabase = myDBHelper.writableDatabase

        // 오늘 날짜
        val calendar = Calendar.getInstance()
        val cYear = calendar.get(Calendar.YEAR)
        val cMonth = calendar.get(Calendar.MONTH) // 0~11
        val cDay = calendar.get(Calendar.DAY_OF_MONTH)
        var diaryDate = "${cYear}-${cMonth+1}-${cDay}"
        Log.d("sql diaryDate :", diaryDate)

        binding.edtDiary.setText(readDiary(diaryDate)) // 오늘 날짜 일기 로딩
        binding.btnWrite.isEnabled = true

        binding.datePicker.init(cYear, cMonth, cDay) { datePicker, year, month, day ->
            // 선택된 날짜 일기 가져오기
            // 선택된 날짜로 diaryDate 수정
            diaryDate = "${year}-${month+1}-${day}"
            Log.d("sql SelectDiaryDate :", diaryDate)
            binding.edtDiary.setText(readDiary(diaryDate))
        }

        // 버튼 클릭 이벤트
        binding.btnWrite.setOnClickListener {
            // 데이터베이스에 일기 저장
            // 쓰기 모드 데이터베이스
            sqLiteDatabase = myDBHelper.writableDatabase

            // sql 쿼리
            var sql = "insert into myDiary values('${diaryDate}', '${binding.edtDiary.text}')"

            if (binding.btnWrite.text.equals("수정")) {
                // 수정 시, insert가 아닌 update
                sql = "update myDiary set content='${binding.edtDiary.text}' " +
                        "where diaryDate = '${diaryDate}'"
                Log.d("sql update :", sql)
            }
            else {
                Log.d("sql insert :", sql)
            }

            // sql 쿼리 실행
            sqLiteDatabase.execSQL(sql)
            // 데이터베이스 닫기
            sqLiteDatabase.close()

            Toast.makeText(this, "입력완료", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readDiary(diaryDate: String): String {
        // 조회된 일기 내용 저장할 변수
        var strResult = ""
        // 읽기 모드 데이터베이스 열기
        // 데이터베이스가 수정되지 않으므로 조회만 가능 -> 수정은 버튼 클릭해야만!
        sqLiteDatabase = myDBHelper.readableDatabase

        // diaryDate 와 일치하는 날짜 조회
        val sql = "select * from myDiary where diaryDate = '$diaryDate'"
        Log.d("sql select :", sql)

        // Cursor : 쿼리 결과 데이터 행을 읽을 수 있는 객체
        var cursor:Cursor = sqLiteDatabase.rawQuery(sql, null)
        if (cursor.moveToNext()) {
            // 두번째 칼럼인 content 값을 읽기 위해 index 값 1
            strResult = cursor.getString(1)
            binding.btnWrite.text = "수정"
            Toast.makeText(this, "일기 조회 ${strResult}", Toast.LENGTH_SHORT).show()
        } else {
            // 일치하는 데이터가 없을 경우, 즉 저장된 데이터가 없을 때
            binding.btnWrite.text = "저장"
            binding.edtDiary.setText(null)
        }
        // cursor 사용 끝난 후 리소스 해제
        cursor.close()

        return strResult
    }

    // 내부 클래스
    class MyDBHelper(context: Context):SQLiteOpenHelper(context, "myDB", null, 1) {
        // 데이터베이스 처음 생성 시 호출, 테이블 생성
        override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
            // diaryDate, content 컬럼 가진 테이블 생성
            sqLiteDatabase.execSQL("create table if not exists " +
                    "myDiary(diaryDate char(10),content varchar(500))")
        }
        // 데이터베이스 버전 변경 시 호출, 테이블 삭제 후 새로 생성
        override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, p1: Int, p2: Int) {
            sqLiteDatabase.execSQL("drop table if exists myDiary")
        }
    }
}