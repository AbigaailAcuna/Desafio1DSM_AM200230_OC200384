package com.example.desafio1_am200230_oc200384

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

lateinit var NombreEmpleado : EditText
lateinit var SalarioBase : EditText
lateinit var Calculo : Button
lateinit var SalarioBaseRespuesta : TextView
lateinit var ISSS : TextView
lateinit var AFP : TextView
lateinit var Renta : TextView

class EmpleadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleado)


        NombreEmpleado = findViewById(R.id.LblNombreEmpleado)
        SalarioBase = findViewById(R.id.LblSalarioBase)
        Calculo = findViewById(R.id.btnCalcularSalario)
        SalarioBaseRespuesta = findViewById(R.id.txtSalarioBase)
        ISSS = findViewById(R.id.txtISSS)
        AFP = findViewById(R.id.txtAFP)
        Renta = findViewById(R.id.txtRenta)



        Calculo.setOnClickListener {
            val calculadoraSalario = CalculadoraSalario(NombreEmpleado, SalarioBase)
            val salarioNeto = calculadoraSalario.calcularSalarioNeto()
            SalarioBaseRespuesta.text = salarioNeto.salarioNeto.toString()
            ISSS.text = salarioNeto.isss.toString()
            AFP.text = salarioNeto.afp.toString()
            Renta.text = salarioNeto.renta.toString()
        }


    }
}