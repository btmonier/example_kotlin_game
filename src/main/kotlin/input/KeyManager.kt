package input

import java.awt.event.KeyEvent
import java.awt.event.KeyListener


class KeyManager : KeyListener {
    private val keys: BooleanArray = BooleanArray(256)

    var up     = false
    var down   = false
    var left   = false
    var right  = false

    var aUp    = false
    var aDown  = false
    var aLeft  = false
    var aRight = false

    fun update() {
        up     = keys[KeyEvent.VK_W]
        down   = keys[KeyEvent.VK_S]
        left   = keys[KeyEvent.VK_A]
        right  = keys[KeyEvent.VK_D]
        aUp    = keys[KeyEvent.VK_UP]
        aDown  = keys[KeyEvent.VK_DOWN]
        aLeft  = keys[KeyEvent.VK_LEFT]
        aRight = keys[KeyEvent.VK_RIGHT]
    }

    override fun keyPressed(e: KeyEvent) {
        keys[e.keyCode] = true
    }

    override fun keyReleased(e: KeyEvent) {
        keys[e.keyCode] = false
    }

    override fun keyTyped(e: KeyEvent) {}

}