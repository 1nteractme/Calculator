import java.lang.Exception

class Calculator(private val io: IO, private val base: Int) {
    fun run() {
        while (true) {
            val input = io.read()
            if (input.trim().equals("stop", ignoreCase = true)) break

            try {
                val result = evaluateExpression(input)
                io.write(result.toBase(base))
            } catch (e: Exception) {
                io.write("Неверный формат выражения")
            }
        }
    }

    private fun evaluateExpression(expression: String): Long {
        val parse = expression.replace("\\s+".toRegex(), "")
        val pattern = """(-?\d+)([+\-*/])(-?\d+)""".toRegex()
        val matchResult = pattern.matchEntire(parse)

        if (matchResult != null) {
            val (num1, operator, num2) = matchResult.destructured
            val fn = num1.toLong()
            val en = num2.toLong()

            return when (operator) {
                "+" -> fn + en
                "-" -> fn - en
                "*" -> fn * en
                "/" -> if (en != 0L) fn / en else throw IllegalArgumentException("Деление на ноль")
                else -> throw IllegalArgumentException("Неверный оператор")
            }
        } else throw IllegalArgumentException("Неверный формат выражения")
    }

    fun Long.toBase(base: Int): String {
        if (base < 2 || base > 36) throw IllegalArgumentException("Incorrect Base. Base must be between 2 and 36")
        return this.toString(base)
    }
}