package input

import java.awt.event.MouseEvent
import java.awt.event.MouseListener

class MouseManger : MouseListener {
    private var x = 0
    private var y = 0

    override fun mouseClicked(e: MouseEvent?) {
        println("input.Mouse clicked")
    }

    override fun mousePressed(e: MouseEvent?) {
        println("input.Mouse pressed")
    }

    override fun mouseReleased(e: MouseEvent?) {
        println("input.Mouse released")
    }

    override fun mouseEntered(e: MouseEvent?) {
//        TODO("Not yet implemented")
    }

    override fun mouseExited(e: MouseEvent?) {
//        TODO("Not yet implemented")
    }
}