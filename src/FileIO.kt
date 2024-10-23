import java.io.File

class FileIo(private val filename: String) : IO {
    private var l: List<String> = File(filename).readLines()
    private var i: Int = 0

    init {
        clearOutputFile()
    }

    private fun clearOutputFile() {
        File("output.txt").writeText("")
    }

    override fun read(): String {
        return if (i < l.size) l[i++].trim() else ""
    }

    override fun write(output: String) {
        File("output.txt").appendText(output + "\n")
    }
}