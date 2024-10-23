fun main() {
    println("Выберите основание системы счисления (от 2 до 36): ")
    val base = readlnOrNull()?.toIntOrNull()?.takeIf { it in 2..36 } ?: run {
        println("Некорректное основание. Используется основание по умолчанию 10.")
        10
    }

    println("Выберите способ ввода данных (console/file): ")
    val choice = readlnOrNull()

    val io: IO = if (choice.equals("file", ignoreCase = true)) FileIo("input.txt") else ConsoleIO()

    val calculator = Calculator(io, base)
    calculator.run()
}