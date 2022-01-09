package states

import java.awt.Graphics

abstract class State {
    abstract fun update()
    abstract fun render(g: Graphics)

    companion object {
        var state: State? = null
    }
}