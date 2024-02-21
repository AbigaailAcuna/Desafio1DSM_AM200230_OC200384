package com.example.desafio1_am200230_oc200384

import android.widget.EditText

class CalcularPromedio(val nombre: EditText, val notas: List<EditText>) {

    data class ResultadosCalculo(
        val promedio: Double,
        val aprobado: Boolean
    )

    // Método para calcular el promedio y determinar si está aprobado

    fun calcularPromedio(): ResultadosCalculo {
        val nombreEstudiante = nombre.text.toString()
        val notasEstudiante = notas.map { it.text.toString().toDouble() }
        val promedio = notasEstudiante.average()
        val aprobado = promedio >= 6.0

        return ResultadosCalculo(promedio, aprobado)
    }

    // Método para determinar si el estudiante está aprobado o no
    fun estaAprobado(): Boolean {
        return calcularPromedio().aprobado
    }
}
