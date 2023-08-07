package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val peso = findViewById<TextInputEditText>(R.id.textInputPeso)
        val estatura = findViewById<TextInputEditText>(R.id.textInputEstatura)
        val boton = findViewById<Button>(R.id.ButtonResultado)

        boton.setOnClickListener{
            val imc:Double = peso.text.toString().toDouble() / Math.pow(estatura.text.toString().toDouble(),2.0)
            val resultado = findViewById<TextView>(R.id.tvresultado)
            resultado.text = "${calculaIMC(imc)} \n IMC = ${String.format("%.2f",imc)}"
        }
    }
    fun calculaIMC(a:Double):String{
        when(a){
            in 0.0..18.5 -> return "Peso Bajo"
            in 18.51..24.99999999 -> return  "Peso Normal"
            in 25.0..29.999999999 -> return  "Sobre Peso"
            in 30.0..100.0 -> return "Peligro Obesidad"
            else -> return "Datos erroneos vuelva a introducir datos"
        }
    }
}