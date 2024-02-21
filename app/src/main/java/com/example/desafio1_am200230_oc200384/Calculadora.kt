import android.widget.EditText
class CalculadoraResultado(val num1: EditText, val num2: EditText, val operador: EditText) {

    // Método para calcular el resultado de la operación
    private fun validarNumeros(): Boolean {
        val numero1 = num1.text.toString().toDoubleOrNull()
        val numero2 = num2.text.toString().toDoubleOrNull()

        return numero1 != null && numero2 != null && numero1 > 0 && numero2 > 0
    }
    fun calcularResultado(): Double {
        val numero1 = num1.text.toString().toDouble()
        val numero2 = num2.text.toString().toDouble()
        val operacion = operador.text.toString()

        return when (operacion) {
            "+" -> numero1 + numero2
            "-" -> numero1 - numero2
            "*" -> numero1 * numero2
            "/" -> numero1 / numero2
            else -> throw IllegalArgumentException("Operador no válido")
        }
    }
}
