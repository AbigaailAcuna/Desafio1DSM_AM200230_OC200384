package com.example.desafio1_am200230_oc200384

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


lateinit var Estudiante : Button
lateinit var Empleado : Button
lateinit var Calculadora: Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Estudiante = findViewById(R.id.btnEstudiante)
        Empleado = findViewById(R.id.btnEmpleado)
        Calculadora = findViewById(R.id.btnCalculadora)

        //Eventos de botones
        Estudiante.setOnClickListener {
            val intent = Intent(this, PromedioActivity::class.java)
            startActivity(intent)
        }
        Empleado.setOnClickListener {
            val intent = Intent(this, EmpleadoActivity::class.java)
            startActivity(intent)
        }
        Calculadora.setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }
    }
}