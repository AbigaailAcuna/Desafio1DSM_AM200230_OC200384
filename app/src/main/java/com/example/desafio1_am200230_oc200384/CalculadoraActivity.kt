package com.example.desafio1_am200230_oc200384

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var edtNum1: EditText
    private lateinit var edtNum2: EditText
    private lateinit var edtOperador: EditText
    private lateinit var btnCalcular: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        edtNum1 = findViewById(R.id.edtNum1)
        edtNum2 = findViewById(R.id.edtNum2)
        edtOperador = findViewById(R.id.edtOperador)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val num1 = edtNum1.text.toString().toDouble()
            val num2 = edtNum2.text.toString().toDouble()
            val operador = edtOperador.text.toString()

            val resultado = calcularResultado(num1, num2, operador)
            txtResultado.text = "Resultado: $resultado"
        }
    }


    private fun calcularResultado(num1: Double, num2: Double, operador: String): Double {
        return when (operador) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> throw IllegalArgumentException("Operador no válido")

        }
    }
}