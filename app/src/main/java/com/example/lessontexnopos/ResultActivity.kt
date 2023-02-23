package com.example.lessontexnopos

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessontexnopos.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val username = intent.getStringExtra("user_name")
        val sorawlarSani = intent.getIntExtra("sorawlarSani",0)
        val juwaplarSani = intent.getIntExtra("juwaplarSani",0)


        binding.username.text = "$username"
        binding.tvSizeQuestions.text = "Sorawlar sani : $sorawlarSani"
        binding.tvSizeAnswers.text = "Duris juwaplar sani : $juwaplarSani"

        binding.btnQaytaOynaw.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}