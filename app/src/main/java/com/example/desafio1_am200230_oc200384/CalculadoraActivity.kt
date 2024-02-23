package com.example.desafio1_am200230_oc200384

import CalculadoraResultado
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

 lateinit var edtNum1: EditText
 lateinit var edtNum2: EditText
 lateinit var edtOperador: EditText
 lateinit var btnCalcular: Button
 lateinit var LblResultado: TextView
 lateinit var calculadora: CalculadoraResultado

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        edtNum1 = findViewById(R.id.edtNum1)
        edtNum2 = findViewById(R.id.edtNum2)
        edtOperador = findViewById(R.id.edtOperador)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        calculadora = CalculadoraResultado(edtNum1, edtNum2, edtOperador)

        btnCalcular.setOnClickListener {
            val num1 = edtNum1.text.toString().toDoubleOrNull()
            val num2 = edtNum2.text.toString().toDoubleOrNull()
            val operador = edtOperador.text.toString()


            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Por favor, introduzca NUMEROS a operar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val resultado = calculadora.calcularResultado()
            txtResultado.text = "Resultado: $resultado"
        }
    }
}
