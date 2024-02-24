import android.widget.EditText
import android.widget.Toast

class CalculadoraResultado(val num1: EditText, val num2: EditText, val operador: EditText) {

    // Método para calcular el resultado de la operación
    private fun validarNumeros(): Boolean {
        val numero1 = num1.text.toString().toDoubleOrNull()
        val numero2 = num2.text.toString().toDoubleOrNull()

        return numero1 != null && numero2 != null && numero1 >= 0 && numero2 >=0
    }

    fun calcularResultado(): Double {


        val numero1 = num1.text.toString().toDouble()
        val numero2 = num2.text.toString().toDouble()
        val operacion = operador.text.toString()

        return try {
            when (operacion) {
                "+" -> numero1 + numero2
                "-" -> numero1 - numero2
                "*" -> numero1 * numero2
                "/" -> {
                    if (numero2 != 0.0) {
                        numero1 / numero2
                    } else {

                        Toast.makeText(num1.context, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                        0.0
                    }
                }
                else -> {

                    Toast.makeText(num1.context, "Operador no válido", Toast.LENGTH_SHORT).show()
                    0.0
                }
            }
        } catch (ex: IllegalArgumentException) {

            Toast.makeText(num1.context, "Ha ocurrido un error al realizar el cálculo", Toast.LENGTH_SHORT).show()
            0.0
        }
    }
}
