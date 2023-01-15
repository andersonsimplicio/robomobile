package com.example.robo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val enviarBt:Button = findViewById<Button>(R.id.enviarBtn)
        val mathBtn: Switch  =  findViewById<Switch>(R.id.mathBtn)

        mathBtn.setOnCheckedChangeListener { _,checked ->
            if(checked) {
                val intent: Intent = Intent(this, MathActivity::class.java)
                startActivity(intent)
            }
        }
        enviarBt.setOnClickListener {
            val msg:String = findViewById<EditText>(R.id.mensagem).text.toString()
            val intent:Intent= Intent(this,RespostaActivity::class.java)
            intent.putExtra("msg",msg)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val edit:EditText = findViewById<EditText>(R.id.mensagem)
        val mathBtn: Switch  =  findViewById<Switch>(R.id.mathBtn)
        mathBtn.isChecked = false
        edit.text.clear();
    }
}