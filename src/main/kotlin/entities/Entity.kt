package entities

import utilities.Constants
import utilities.Handler
import java.awt.Graphics
import java.awt.Rectangle

abstract class Entity(
    var handler: Handler,
    var x: Float,
    var y: Float,
    var width: Int,
    var height: Int,
    var bounds: Rectangle = Rectangle(0, 0, width, height),
    var health: Int = Constants.Entity.DEFAULT_HEALTH,
    var active: Boolean = true
) {
    abstract fun update()
    abstract fun render(g: Graphics)

    fun hurt(amt: Int) {
        health -= amt

        if (health <= 0) {
            active = false
            die()
        }
    }

    abstract fun die()

    fun getCollisionBounds(xOffset: Float, yOffset: Float): Rectangle {
        return Rectangle(
            (x + bounds.x + xOffset).toInt(),
            (y + bounds.y + yOffset).toInt(),
            bounds.width,
            bounds.height
        )
    }

    fun checkEntityCollisions(xOffset: Float, yOffset: Float): Boolean {
        for (e in handler.world!!.entityManager.entities) {
            if (e == this) {
                continue
            }
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                return true
            }
        }
        return false
    }
}