package entities

import gfx.Assets
import utilities.Handler
import java.awt.Graphics

class Rock(handler: Handler, x: Float, y: Float, width: Int, height: Int) : StaticEntity(handler, x, y, width, height) {
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
    }
}