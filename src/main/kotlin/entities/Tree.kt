package entities

import gfx.Assets
import utilities.Constants
import utilities.Handler
import java.awt.Color
import java.awt.Graphics

class Tree(handler: Handler, x: Float, y: Float, width: Int, height: Int) : StaticEntity(handler, x, y, width, height) {

    private val debug = true
    init {
        bounds.x      = 6 * Constants.Assets.SCALE
        bounds.width  = 6 * Constants.Assets.SCALE
        bounds.y      = 23 * Constants.Assets.SCALE
        bounds.height = 9 * Constants.Assets.SCALE
    }

    override fun update() {}

    override fun render(g: Graphics) {
        g.drawImage(
            Assets.tree,
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

    override fun die() {}
}