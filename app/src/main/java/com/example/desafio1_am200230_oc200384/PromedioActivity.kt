package com.example.desafio1_am200230_oc200384

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PromedioActivity : AppCompatActivity() {

    private lateinit var edtNombreEstudiante: EditText
    private lateinit var edtNota1: EditText
    private lateinit var edtNota2: EditText
    private lateinit var edtNota3: EditText
    private lateinit var edtNota4: EditText
    private lateinit var edtNota5: EditText
    private lateinit var btnCalcularPromedio: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio)

        edtNombreEstudiante = findViewById(R.id.edtNombreEstudiante)
        edtNota1 = findViewById(R.id.edtNota1)
        edtNota2 = findViewById(R.id.edtNota2)
        edtNota3 = findViewById(R.id.edtNota3)
        edtNota4 = findViewById(R.id.edtNota4)
        edtNota5 = findViewById(R.id.edtNota5)
        btnCalcularPromedio = findViewById(R.id.btnCalcularPromedio)
        txtResultado = findViewById(R.id.txtResultado)

        btnCalcularPromedio.setOnClickListener {
            val nombreEstudiante = edtNombreEstudiante.text.toString()
            val notas = mutableListOf<Double>()
            notas.add(edtNota1.text.toString().toDouble())
            notas.add(edtNota2.text.toString().toDouble())
            notas.add(edtNota3.text.toString().toDouble())
            notas.add(edtNota4.text.toString().toDouble())
            notas.add(edtNota5.text.toString().toDouble())

            val promedio = calcularPromedio(notas)
            val resultado = if (promedio >= 60) "aprobado" else "reprobado"

            txtResultado.text = "El promedio del estudiante $nombreEstudiante es: $promedio. Está $resultado."
        }
    }

    private fun calcularPromedio(notas: List<Double>): Double {
        // Suma de todas las notas
        val sumaNotas = notas.sum()

        // Calcula el promedio
        return sumaNotas / notas.size
    }
}
