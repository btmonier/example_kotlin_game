package states

import gfx.Assets
import ui.ClickListener
import ui.UIImageButton
import ui.UIManager
import utilities.Constants
import utilities.Handler
import java.awt.Graphics

class MenuState(val handler: Handler, private val uiManager: UIManager = UIManager(handler)) : State() {
    init {
        handler.getMouseManager().uiManager = uiManager
        uiManager.addObject(
            UIImageButton(
                (Constants.Window.SCREEN_WIDTH / 2).toFloat() - 64,
                (Constants.Window.SCREEN_HEIGHT / 2).toFloat() - 32,
                128,
                64,
                Assets.btnStart,
                object : ClickListener {
                    override fun onClick() {
                        State.state = handler.game.gameState
                    }
                })
        )
    }


    override fun update() {
        uiManager.update()
    }

    override fun render(g: Graphics) {
        uiManager.render(g)
    }
}