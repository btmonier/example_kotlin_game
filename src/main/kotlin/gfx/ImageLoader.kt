package gfx

import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO
import kotlin.system.exitProcess

class ImageLoader {
    fun loadImage(path: String): BufferedImage? {
        try {
            return ImageIO.read(File(path))
        } catch(e: IOException) {
            e.printStackTrace()
            exitProcess(1)
        }
    }
}