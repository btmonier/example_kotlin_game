package ui

import java.awt.Graphics
import java.awt.Rectangle
import java.awt.event.MouseEvent

abstract class UIObject(
    protected var x: Float,
    protected var y: Float,
    protected var width: Int,
    protected var height: Int,
    protected var hovering: Boolean = false,
    protected val bounds: Rectangle = Rectangle(x.toInt(), y.toInt(), width, height)
) {
    abstract fun update()
    abstract fun render(g: Graphics)
    abstract fun onClick()

    fun onMouseMove(e: MouseEvent) {
        hovering = bounds.contains(e.x, e.y)
    }

    fun onMouseRelease(e: MouseEvent) {
        if (hovering) {
            onClick()
        }
    }
}