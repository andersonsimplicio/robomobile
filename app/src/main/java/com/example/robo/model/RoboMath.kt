package com.example.robo.model

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.example.robo.R

open class RoboMath: Robo() {


    fun contaResp(conta: String?): Float {
        val palavras: List<String>?;
        if (conta != null) {
            if("+" in conta) {
                val palavras = conta?.split('+')
                val n1: String? = palavras?.get(0)?.replace(" ", "")
                val n2: String? = palavras?.get(1)?.replace(" ", "")
                val s1 = n1?.toFloat()
                val s2 = n2?.toFloat()
                if (s1 != null) {
                    return s1 + s2!!
                }
            }else{
                if("-" in conta){
                    val palavras = conta?.split('-')
                    val n1: String? = palavras?.get(0)?.replace(" ", "")
                    val n2: String? = palavras?.get(1)?.replace(" ", "")
                    val s1 = n1?.toFloat()
                    val s2 = n2?.toFloat()
                    if (s1 != null) {
                        return s1 - s2!!
                    }
                }else{
                    if("*" in conta){
                        val palavras = conta?.split('*')
                        val n1: String? = palavras?.get(0)?.replace(" ", "")
                        val n2: String? = palavras?.get(1)?.replace(" ", "")
                        val s1 = n1?.toFloat()
                        val s2 = n2?.toFloat()
                        if (s1 != null && s2 != null) {
                            return s1 * s2
                        }
                    }else {
                        val palavras = conta?.split('/')
                        val n1: String? = palavras?.get(0)?.replace(" ", "")
                        val n2: String? = palavras?.get(1)?.replace(" ", "")
                        val s1 = n1?.toFloat()
                        val s2 = n2?.toFloat()
                        if (s1 != null && s2 != null && s2.toInt() != 0) {
                            return s1 / s2
                        }
                    }
                }
            }
        }
        return "0".toFloat()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun responda(
        text: String?,
        conta: String?,
        img: ImageView?,
        context: Context?
    ): String {
        if(!conta.isNullOrEmpty()) {
            Log.i("Calculadora",conta)
            if (img != null) {
                if (context != null) {
                    img.setImageDrawable(context.getDrawable(R.drawable.robook))
                };
            }
             return "Essa eu sei $conta =  ${contaResp(conta)}"
        }else {
            if (img != null) {
                if (context != null) {
                    img.setImageDrawable(context.getDrawable(R.drawable.robobravo))
                };
                if (conta != null) {
                    Log.i("Calc",conta)
                }
                return "Não Sei fazer essa conta"
            }
             return "Não Sei fazer essa conta"
        }
    }
}