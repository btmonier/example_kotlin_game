package ui

import utilities.Handler
import java.awt.Graphics
import java.awt.event.MouseEvent
import java.util.*


class UIManager(var handler: Handler, var objects: ArrayList<UIObject> = ArrayList()) {

    fun update() {
        for (o in objects) o.update()
    }

    fun render(g: Graphics?) {
        for (o in objects) o.render(g!!)
    }

    fun onMouseMove(e: MouseEvent?) {
        for (o in objects) o.onMouseMove(e!!)
    }

    fun onMouseRelease(e: MouseEvent?) {
        for (o in objects) o.onMouseRelease(e!!)
    }

    fun addObject(o: UIObject) {
        objects.add(o)
    }

    fun removeObject(o: UIObject) {
        objects.remove(o)
    }

}