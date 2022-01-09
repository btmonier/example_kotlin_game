package utilities

import java.io.File

fun generateRandomWorld(dimX: Int, dimY: Int, pX: Int, pY: Int, filePath: String) {
    val tiles  = Array(dimY) { IntArray(dimX) }
    for (i in 0 until dimY) {
        for (j in 0 until dimX) {
            tiles[i][j] = (0..1).random()
        }
    }

    File(filePath).bufferedWriter().use {
        it.write("$dimX $dimY\n")
        it.write("$pX $pY\n")
        var j = 0
        for (i in tiles.indices) {
            it.write(tiles[i].joinToString(" "))
            j++
            if (j < dimY) {
                it.write("\n")
            }
        }
    }
}

fun main() {
    generateRandomWorld(50, 40, 10, 10, "res/random_world.txt")
}