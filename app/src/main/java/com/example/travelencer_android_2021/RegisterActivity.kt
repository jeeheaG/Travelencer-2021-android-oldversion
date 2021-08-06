package com.example.travelencer_android_2021

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.travelencer_android_2021.api.RetrofitClient
import com.example.travelencer_android_2021.data.JoinData
import com.example.travelencer_android_2021.data.JoinResponse
import com.example.travelencer_android_2021.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Response

// 회원가입 액티비티
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 뒤로가기 이미지 클릭
        imgBack.setOnClickListener {
            finish()
        }

        // 비밀번호 일치하는지 확인
        var passwordCheck = false
        binding.tvPassword1.doOnTextChanged { text, start, before, count ->
            if(binding.tvPassword1.text.toString().equals(binding.tvPassword2.text.toString())) {
                binding.tvPasswordCheck.visibility = View.INVISIBLE
                binding.tvPassword2.setTextColor(Color.BLACK)
                passwordCheck = true
            }
            else {
                binding.tvPasswordCheck.visibility = View.VISIBLE
                binding.tvPassword2.setTextColor(Color.RED)
                passwordCheck = false
            }
        }
        binding.tvPassword2.doOnTextChanged { text, start, before, count ->
            if(binding.tvPassword1.text.toString().equals(binding.tvPassword2.text.toString())) {
                binding.tvPasswordCheck.visibility = View.INVISIBLE
                binding.tvPassword2.setTextColor(Color.BLACK)
                passwordCheck = true
            }
            else {
                binding.tvPasswordCheck.visibility = View.VISIBLE
                binding.tvPassword2.setTextColor(Color.RED)
                passwordCheck = false
            }
        }

        // <가입하기> 버튼 클릭
        btnRegister.setOnClickListener {
            // 이름 검사
            val name = binding.tvName.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(applicationContext, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // 닉네임 검사
            val nickname = binding.tvNickname.text
            // 이메일 검사
            val email = binding.tvEmailId.text.toString()
            if (!isEmailValid(email.toString())) {
                Toast.makeText(applicationContext, "이메일이 유효하지 않습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // 비밀번호 검사
            val password = binding.tvPassword2.text.toString()
            if (password.isEmpty()) {
                Toast.makeText(applicationContext, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!passwordCheck) {
                Toast.makeText(applicationContext, "비밀번호를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!isPasswordValid(password)) {
                Toast.makeText(applicationContext, "비밀번호를 6자리 이상 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // 약관 동의 검사
            if (btnRegister.isEnabled != checkbox.isChecked) {
                Toast.makeText(applicationContext, "서비스 이용 약관 및 개인정보 보호정책에 동의해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            startJoin(JoinData(name, email, password))
            finish()
        }

    }

    // 이메일 형식 체크
    private fun isEmailValid(email : String) : Boolean {
        val pattern = android.util.Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    // 비밀번호 6자리 이상인지 확인
    private fun isPasswordValid(password : String) : Boolean {
        return password.length >= 6
    }

    // 회원가입하기
    private fun startJoin(data : JoinData) {
        val call = RetrofitClient.serviceApi.userJoin(data)
        call.enqueue(object : retrofit2.Callback<JoinResponse> {
            // 응답 성공 시
            override fun onResponse(call: Call<JoinResponse>, response: Response<JoinResponse>) {
                if (response.isSuccessful) {
                    val result : JoinResponse = response.body()!!
                    Toast.makeText(applicationContext, result.message, Toast.LENGTH_SHORT).show()
                    Log.d("mmm회원가입 성공", response.message())
                }
            }

            // 응답 실패 시
            override fun onFailure(call: Call<JoinResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "회원가입 에라 발생", Toast.LENGTH_SHORT).show()
                Log.d("mmm 회원가입 fail", t.message.toString())
            }
        })
    }

}
