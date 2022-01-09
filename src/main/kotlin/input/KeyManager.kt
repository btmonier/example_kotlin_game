package input

import java.awt.event.KeyEvent
import java.awt.event.KeyListener


class KeyManager : KeyListener {
    private val keys: BooleanArray = BooleanArray(256)

    var up    = false
    var down  = false
    var left  = false
    var right = false

    fun update() {
        up    = keys[KeyEvent.VK_W]
        down  = keys[KeyEvent.VK_S]
        left  = keys[KeyEvent.VK_A]
        right = keys[KeyEvent.VK_D]
    }

    override fun keyPressed(e: KeyEvent) {
        keys[e.keyCode] = true
    }

    override fun keyReleased(e: KeyEvent) {
        keys[e.keyCode] = false
    }

    override fun keyTyped(e: KeyEvent) {}

}