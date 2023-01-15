package com.example.robo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.robo.model.Robo
import com.example.robo.model.RoboMath
import kotlin.math.log





class RespostaActivity : AppCompatActivity(R.layout.activity_resposta) {
    fun operadorConta(text:String?):String{
        var palavras:List<String>?
        palavras = text?.split(" ")
        palavras?.forEach {
            return it
        }
        return ""
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val voltarBtn:Button = findViewById<Button>(R.id.voltarBtn)
        val msg: Bundle? = intent.extras
        val quest: String? = msg?.getString("msg")
        val calc: String? = msg?.getString("calc")
        val resposta: TextView = findViewById<TextView>(R.id.resposta)
        val img: ImageView = findViewById<ImageView>(R.id.botChatR)
        if(quest?.isEmpty() != true && quest!=null) {
            val robot: Robo = Robo()
            resposta.text = robot.responda(quest, null,img, this)
        }else{
            if(calc?.isEmpty()!=true && calc != null){
              // Log.i("Calc",calc)
              val roboMath:RoboMath = RoboMath()
               resposta.text = roboMath.responda(null,calc,img,this)
            }else{
                img.setImageDrawable(getDrawable(R.drawable.robobravo))
                resposta.text = "Essa Conta não sei fazer"
            }
        }


        voltarBtn.setOnClickListener {
            finish()
        }
    }
}


