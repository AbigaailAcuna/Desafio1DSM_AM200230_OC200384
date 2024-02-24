package com.example.desafio1_am200230_oc200384

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
lateinit var nombreempleado: TextView

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
        nombreempleado = findViewById(R.id.txtEmpleado)


        Calculo.setOnClickListener {
            //validaciones
            val nombre = NombreEmpleado.text.toString()
            val salario = SalarioBase.text.toString()

            if (nombre.isNotEmpty() && salario.isNotEmpty()){
                if(salario > "0.0")
                {
                    val calculadoraSalario = CalculadoraSalario(nombre, salario)
                    val salarioNeto = calculadoraSalario.calcularSalarioNeto()
                    SalarioBaseRespuesta.text = String.format("$ %.2f", salarioNeto.salarioNeto)
                    nombreempleado.text = nombre
                    ISSS.text = String.format("$ %.2f", salarioNeto.isss)
                    AFP.text = String.format("$ %.2f", salarioNeto.afp)
                    Renta.text = String.format("$ %.2f", salarioNeto.renta)
                    // Log.d("NombreEmpleado", "Nombre: $nombre")
                    // Log.d("NombreEmpleado2", "Nombre: " +calculadoraSalario.nombre.toString())
                }else{
                    Toast.makeText(this, "Por favor, introduzca un salario válido", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "Por favor, introduzca los campos requeridos", Toast.LENGTH_SHORT).show()
                ISSS.text = ""
                AFP.text = ""
                Renta.text = ""
                SalarioBaseRespuesta.text = ""
                nombreempleado.text = ""
            }
        }


    }
}