package entities

import utilities.Handler
import java.awt.Graphics
import java.awt.Rectangle

abstract class Entity(
    var handler: Handler,
    var x: Float,
    var y: Float,
    var width: Int,
    var height: Int,
    var bounds: Rectangle = Rectangle(0, 0, width, height)
) {
    abstract fun update()
    abstract fun render(g: Graphics)
}