package com.example.desafio1_am200230_oc200384

import android.widget.EditText
import android.widget.Button

class CalculadoraSalario(val nombre: EditText, val salarioBase: EditText) {

    data class ResultadosCalculo(
        val salarioNeto: Double,
        val isss: Double,
        val afp: Double,
        val renta: Double,
        val descuentosTotal: Double
    )


    public val porcentajeISSS = 0.03
    public val porcentajeAFP = 0.04
    public val porcentajeRenta = 0.05

    // Método para calcular Salario neto
    fun calcularSalarioNeto(): ResultadosCalculo {
        val salarioBaseDouble = salarioBase.text.toString().toDouble()

        val isss = salarioBaseDouble * porcentajeISSS
        val afp = salarioBaseDouble * porcentajeAFP
        val renta = salarioBaseDouble * porcentajeRenta

        val descuentosTotal = isss + afp + renta
        val salarioNeto = salarioBaseDouble - descuentosTotal

        return ResultadosCalculo(salarioNeto, isss, afp, renta, descuentosTotal)
    }
}
