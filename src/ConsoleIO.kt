class ConsoleIO : IO {
    override fun read(): String {
        return readlnOrNull() ?: ""
    }

    override fun write(output: String) {
        println(output)
    }
}