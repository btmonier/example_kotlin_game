package gfx

import entities.Entity
import utilities.Constants
import utilities.Handler

class GameCamera(val handler: Handler, var xOffset: Float, var yOffset: Float) {
    fun move(xAmt: Float, yAmt: Float) {
        xOffset += xAmt
        yOffset += yAmt
    }

    private fun checkBlankSpace() {
        val maxBorderX = Constants.Assets.DEFAULT_WIDTH * handler.world!!.width - Constants.Window.SCREEN_WIDTH
        val maxBorderY = Constants.Assets.DEFAULT_HEIGHT * handler.world!!.height - Constants.Window.SCREEN_HEIGHT

        if (xOffset < 0) {
            xOffset = 0f
        } else if (xOffset > maxBorderX) {
            xOffset = maxBorderX.toFloat()
        }

        if (yOffset < 0) {
            yOffset = 0f
        } else if (yOffset > maxBorderY) {
            yOffset = maxBorderY.toFloat()
        }
    }

    fun centerOnEntity(e: Entity) {
        xOffset = e.x - handler.getWidth() / 2 + e.width / 2
        yOffset = e.y - handler.getHeight() / 2 + e.height / 2
        checkBlankSpace()
    }
}