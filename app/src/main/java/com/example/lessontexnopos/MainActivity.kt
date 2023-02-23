package com.example.lessontexnopos

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.lessontexnopos.databinding.ActivityMainBinding
import com.example.lessontexnopos.entity.QuestionsList
import com.genius.multiprogressbar.MultiProgressBar
import com.genius.multiprogressbar.MultiProgressBar.ProgressStepChangeListener

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var indeks = 0
    private var selectedId = 0
    private var rightAnswers = 0
    private var progressBarSost = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        QuestionsList.getQuestion()
        setQuestion()


        binding.statisticTable.text = "$rightAnswers / ${QuestionsList.getQuestion().size}"

        val username = intent.getStringExtra("username")

        object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
//                var seconds = millisUntilFinished
//                var minutes = seconds /60
//                var leftSeconds = seconds - (minutes * 60)
//                binding.tvTimer.text = String.format("%02d:%02d",minutes,leftSeconds)
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity,"Waqit tawsildi!",Toast.LENGTH_SHORT).show()
            }

        }.start()

        binding.tvAnswer1.setOnClickListener {
            selectedId = 1
            checkAnswers()
        }
        binding.tvAnswer2.setOnClickListener {
            selectedId = 2
            checkAnswers()
        }
        binding.tvAnswer3.setOnClickListener {
            selectedId = 3
            checkAnswers()
        }
        binding.tvAnswer4.setOnClickListener {
            selectedId = 4
            checkAnswers()
        }

        binding.btnNext.setOnClickListener {
            if (selectedId == 0){
                Toast.makeText(this,"Juwap belgilenbedi !",Toast.LENGTH_SHORT).show()
            }else{
                indeks++
                progressBarSost++
                if (indeks == QuestionsList.getQuestion().size){
                    val intent =Intent(this,ResultActivity::class.java)
                    intent.putExtra("sorawlarSani",QuestionsList.getQuestion().size)
                    intent.putExtra("juwaplarSani",rightAnswers)
                    intent.putExtra("user_name",username)
                    startActivity(intent)
                }
                setQuestion()
                binding.tvAnswer1.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(this,R.color.color_normal)
                )
                binding.tvAnswer2.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(this,R.color.color_normal)
                )
                binding.tvAnswer3.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(this,R.color.color_normal)
                )
                binding.tvAnswer4.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(this,R.color.color_normal)
                )
                binding.statisticTable.text = "$rightAnswers / ${QuestionsList.getQuestion().size}"
                selectedId = 0

            }

        }



    }

    private fun setQuestion(){
        val question = QuestionsList.getQuestion()[indeks]
        binding.tvSoraw.text = question.question
        binding.tvAnswer1.text = question.answer1
        binding.tvAnswer2.text = question.answer2
        binding.tvAnswer3.text = question.answer3
        binding.tvAnswer4.text = question.answer4
        isEnabledButton(true)
    }

    fun checkAnswers(){
        if (selectedId == 0){
            Toast.makeText(this, "sayla", Toast.LENGTH_SHORT).show()
        }else{
            if (selectedId==QuestionsList.getQuestion()[indeks].durisjuwap){
                rightAnswers++
                when(selectedId){
                    1 -> binding.tvAnswer1.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_duris)
                    )
                    2 -> binding.tvAnswer2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_duris)
                    )
                    3 -> binding.tvAnswer3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_duris)
                    )
                    4 -> binding.tvAnswer4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_duris)
                    )
                }
            }else{
                when(selectedId){
                    1 -> binding.tvAnswer1.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_qate)
                    )
                    2 -> binding.tvAnswer2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_qate)
                    )
                    3 -> binding.tvAnswer3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_qate)
                    )
                    4 -> binding.tvAnswer4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_qate)
                    )
                }
                when(QuestionsList.getQuestion()[indeks].durisjuwap){
                    1 -> binding.tvAnswer1.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_duris)
                    )
                    2 -> binding.tvAnswer2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_duris)
                    )
                    3 -> binding.tvAnswer3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_duris)
                    )
                    4 -> binding.tvAnswer4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this,R.color.color_duris)
                    )
                }
            }
            isEnabledButton(false)

        }
    }

    fun isEnabledButton(boolean: Boolean){
        binding.tvAnswer1.isEnabled = boolean
        binding.tvAnswer2.isEnabled = boolean
        binding.tvAnswer3.isEnabled = boolean
        binding.tvAnswer4.isEnabled = boolean
    }



}


