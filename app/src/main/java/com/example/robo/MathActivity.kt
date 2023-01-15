package com.example.robo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch

class MathActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)
        val mathBtn: Switch =  findViewById<Switch>(R.id.mathBtn)
        mathBtn.setOnCheckedChangeListener { _,checked ->
            finish()
        }
        val calcBtn: Button = findViewById<Button>(R.id.calcBtn)
        calcBtn.setOnClickListener {
            val msg:String = findViewById<EditText>(R.id.campoCalc).text.toString()
            val intent:Intent= Intent(this,RespostaActivity::class.java)
            intent.putExtra("calc",msg)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        val edit:EditText = findViewById<EditText>(R.id.campoCalc)
        edit.text.clear();
    }
}