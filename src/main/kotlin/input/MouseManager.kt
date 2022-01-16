package input

import ui.UIManager
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

class MouseManager(
    var mouseX: Int = 0,
    var mouseY: Int = 0,
    var leftPressed: Boolean = false,
    var rightPressed: Boolean = false,
    var uiManager: UIManager? = null
) : MouseListener, MouseMotionListener {

    override fun mouseClicked(e: MouseEvent) {
    }

    override fun mousePressed(e: MouseEvent) {
        if (e.button == MouseEvent.BUTTON1) {
            leftPressed = true
        } else if (e.button == MouseEvent.BUTTON3) {
            rightPressed = true
        }
    }

    override fun mouseReleased(e: MouseEvent) {
        if (e.button == MouseEvent.BUTTON1) {
            leftPressed = false
        } else if (e.button == MouseEvent.BUTTON3) {
            rightPressed = false
        }

        uiManager?.onMouseRelease(e)
    }

    override fun mouseMoved(e: MouseEvent) {
        mouseX = e.x
        mouseY = e.y
        uiManager?.onMouseMove(e)
    }

    override fun mouseEntered(e: MouseEvent) {
//        TODO("Not yet implemented")
    }

    override fun mouseExited(e: MouseEvent) {
//        TODO("Not yet implemented")
    }

    override fun mouseDragged(e: MouseEvent) {
//        TODO("Not yet implemented")
    }
}