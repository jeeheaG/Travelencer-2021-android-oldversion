package com.example.travelencer_android_2021

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

// 로그인 액티비티
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 뒤로가기 이미지 클릭
        imgBack.setOnClickListener {
            finish()
        }

        // <로그인> 버튼 클릭
        btnLogin.setOnClickListener {
            val id = findViewById<EditText>(R.id.editId).text
            val password = findViewById<EditText>(R.id.editPassWord).text

            Toast.makeText(applicationContext, "아이디 : ${id}, 비밀번호 : ${password}", Toast.LENGTH_SHORT).show()
            finish()
        }

        // <비밀번호 찾기> 텍스트뷰 클릭
        tvPasswordFind.setOnClickListener {
            // PasswordFindActivity로 이동하기
            val intent = Intent(this@LoginActivity, PasswordFindActivity::class.java)
            startActivity(intent)
        }

        // <회원가입> 버튼 클릭
        btnRegister.setOnClickListener {
            // RegisterActivity로 이동하기
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

}