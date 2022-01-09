package entities

import gfx.Assets
import utilities.Constants
import utilities.Handler
import java.awt.Color
import java.awt.Graphics

class Rock(handler: Handler, x: Float, y: Float, width: Int, height: Int) : StaticEntity(handler, x, y, width, height) {

    private val debug = false
    init {
//        bounds.x      = 2
//        bounds.width  = 20
        bounds.y      = 3
        bounds.height = 22
    }

    override fun update() {

    }

    override fun render(g: Graphics) {
        g.drawImage(
            Assets.rock,
            (x - handler.getGameCamera().xOffset).toInt(),
            (y - handler.getGameCamera().yOffset).toInt(),
            width,
            height,
            null
        )

        // DEBUG - bounding box
        if (debug) {
            g.color = Color.PINK
            g.fillRect(
                (x + bounds.x - handler.getGameCamera().xOffset).toInt(),
                (y + bounds.y - handler.getGameCamera().yOffset).toInt(),
                bounds.width,
                bounds.height
            )
        }
    }
}