package com.example.robo.model

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.widget.ImageView
import com.example.robo.R

open class Robo {
    var nome: String

    init {
        this.nome = "Marciano"
    }

    fun isQuest(texto: String?): Boolean {
        var letra = texto?.filter { letra -> letra == '?' }
        return if (letra == "?") true else false;
    }

    fun contemEu(texto: String?): Boolean {
        var palavras: List<String>?;
        palavras = texto?.split(" ", ",", ".")
        palavras?.forEach {
            if (it == "eu" || it == "EU" || it == "Eu" || it == "eU") {
                return true
            }
        }
        return false
    }

    fun isEducado(texto: String?): Boolean {
        var palavras: List<String>? = texto?.split(" ", ",", ".")
        palavras?.forEach {
            val (upperCases, notUpperCases) = it.partition { it.isUpperCase() }
            if (upperCases.isNullOrEmpty())
                return true
        }
        return false
    }

    open fun responda(text: String?,conta: String?,img:ImageView?,context: Context?): String {
        if (!text.isNullOrEmpty()) {
            if (!contemEu(text)) {
                if (isEducado(text)) {
                    if (img != null) {
                        if (context != null) {
                            img.setImageDrawable(context.getDrawable(R.drawable.robook))
                        };
                    }
                    if (isQuest(text)) {
                        return "Certamente!"//Apenas Pergunta
                    }else {
                        return "Tudo bem, como quiser."//fale qualquer outra coisa
                    }
                } else {
                    if (img != null) {
                        if (context != null) {
                            img.setImageDrawable(context.getDrawable(R.drawable.robobravo))
                        };
                    }
                    if (isQuest(text)) {
                        return "Relaxa, eu sei o que estou fazendo!"//gritar com ele em uma pergunta.
                    }else {
                        return "Opa! Calma aí!"//Apenas gritar
                    }
                }
            } else {
                if (img != null) {
                    if (context != null) {
                        img.setImageDrawable(context.getDrawable(R.drawable.robo))
                    };
                }
                return "A responsabilidade é sua!"
            }
        } else {
            if (img != null) {
                if (context != null) {
                    img.setImageDrawable(context.getDrawable(R.drawable.robobravo))
                };
            }
            return "Não me incomode!!!"
        }
    }
}




