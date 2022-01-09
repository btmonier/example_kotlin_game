package utilities

import java.io.File
import java.io.IOException
import kotlin.system.exitProcess

class Utils {
    fun loadFileAsString(path: String): List<String> {
        return try {
            File(path)
                .bufferedReader()
                .readLines()
                .joinToString(" ")
                .split(" ")
        } catch (e: IOException) {
            e.printStackTrace()
            exitProcess(1)
        }
    }
}