package com.example.lessontexnopos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lessontexnopos.databinding.ActivityMainBinding
import com.example.lessontexnopos.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text
            if (name.isEmpty()){
                Toast.makeText(this,"Atinizdi kiritin !",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("username",binding.etName.text.toString())
                startActivity(intent)
            }
        }


    }
}