package com.example.desafio1_am200230_oc200384

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

 lateinit var edtNombreEstudiante: EditText
 lateinit var edtNota1: EditText
 lateinit var edtNota2: EditText
 lateinit var edtNota3: EditText
 lateinit var edtNota4: EditText
 lateinit var edtNota5: EditText
 lateinit var btnCalcularPromedio: Button
 lateinit var txtResultado: TextView


class PromedioActivity : AppCompatActivity() {

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
        txtResultado = findViewById(R.id.lblResultado)

        btnCalcularPromedio.setOnClickListener {
            val nombreEstudiante = edtNombreEstudiante.text.toString()
            val notas = mutableListOf<Double>()

            // Validar que todas las notas sean números válidos y mayores a cero
            var todasLasNotasValidas = true
            for (edtNota in listOf(edtNota1, edtNota2, edtNota3, edtNota4, edtNota5)) {
                val nota = edtNota.text.toString().toDoubleOrNull()
                if (nota == null || nota <= 0) {
                    todasLasNotasValidas = false
                    break
                }
                notas.add(nota)
            }

            if (!todasLasNotasValidas) {
                txtResultado.text = "Por favor, ingrese notas válidas mayores que cero en todos los campos."
                return@setOnClickListener
            }

            val estudiante = CalcularPromedio(edtNombreEstudiante, listOf(edtNota1, edtNota2, edtNota3, edtNota4, edtNota5))

            val resultados = estudiante.calcularPromedio()
            val resultado = if (resultados.aprobado) "aprobado" else "reprobado"

            txtResultado.text = "El promedio del estudiante $nombreEstudiante es: ${resultados.promedio}. Está $resultado."
        }

    }
}
