package com.example.desafio1_am200230_oc200384

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_promedio.*
import java.util.*


class PromedioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio)

        btnCalcularPromedio.setOnClickListener {
            val nombreEstudiante = edtNombreEstudiante.text.toString()
            val notas = mutableListOf<Double>()
            notas.add(edtNota1.text.toString().toDouble())
            notas.add(edtNota2.text.toString().toDouble())
            notas.add(edtNota3.text.toString().toDouble())
            notas.add(edtNota4.text.toString().toDouble())
            notas.add(edtNota5.text.toString().toDouble())

            val promedio = notas.average()

            val resultado = if (promedio >= 60) "aprobado" else "reprobado"

            txtResultado.text = "El promedio del estudiante $nombreEstudiante es: $promedio. Está $resultado."
        }
    }

}