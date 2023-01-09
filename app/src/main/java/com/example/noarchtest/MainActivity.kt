package com.example.noarchtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.noarchtest.databinding.ActivityMainBinding
import com.example.noarchtest.product.ProductActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.send.setOnClickListener {

            val loginId = binding.loginId.text.toString()
            val pwd = binding.password.text.toString()

            val isLoginIdOK = RegisterVerify().isLoginIdVerify(loginId)

            val isPwdOK = RegisterVerify().isPasswordVerify(pwd)

            val builder = AlertDialog.Builder(this)

            if (!isLoginIdOK) {
                // Register fail
                val builder = AlertDialog.Builder(this)

                builder.setMessage("loginId 要至少6位數第一個字大寫")
                    .setTitle("Error")

                builder.show()
            }

            else if (!isPwdOK) {
                val builder = AlertDialog.Builder(this)

                builder.setMessage("Password 要至少6位數第一個字大寫")
                    .setTitle("Error")

                builder.show()
            } else {
                //註冊成功，儲存Id
                Repository(this).saveUserId(loginId)
                val intent = Intent(this, ProductActivity::class.java)
                intent.putExtra("ID", loginId)

                startActivity(intent)
            }
        }
    }
}