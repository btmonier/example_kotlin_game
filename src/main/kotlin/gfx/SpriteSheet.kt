package gfx

import java.awt.image.BufferedImage

class SpriteSheet(private val sheet: BufferedImage?) {

    fun crop(x: Int, y: Int, width: Int, height: Int): BufferedImage? {
        return sheet?.getSubimage(x, y, width, height)
    }
}