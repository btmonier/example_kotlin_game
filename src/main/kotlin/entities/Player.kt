package entities

import gfx.Animation
import gfx.Assets
import utilities.Constants
import utilities.Handler
import java.awt.Graphics
import java.awt.image.BufferedImage

class Player(
    handler: Handler,
    x: Float = 100f,
    y: Float = 100f,
    private val animDown: Animation  = Animation(100, Assets.playerDown),
    private val animUp: Animation    = Animation(100, Assets.playerUp),
    private val animLeft: Animation  = Animation(100, Assets.playerLeft),
    private val animRight: Animation = Animation(100, Assets.playerRight)
) : Creature(handler = handler, x, y, Constants.Assets.DEFAULT_WIDTH, Constants.Assets.DEFAULT_HEIGHT) {

    private val bXP = 0.5
    private val bYP = 0.8
    init {
        bounds.x      = (Constants.Assets.DEFAULT_WIDTH / 2) - ((Constants.Assets.DEFAULT_WIDTH * bXP).toInt() / 2)
        bounds.width  = (Constants.Assets.DEFAULT_WIDTH * bXP).toInt()
        bounds.y      = (Constants.Assets.DEFAULT_HEIGHT * bYP).toInt()
        bounds.height = Constants.Assets.DEFAULT_HEIGHT - (Constants.Assets.DEFAULT_HEIGHT * bYP).toInt()
    }

    override fun update() {
        // Animations
        animDown.update()
        animLeft.update()
        animRight.update()
        animUp.update()

        // Movement
        getInput()
        move()
        handler.getGameCamera().centerOnEntity(this)
    }

    private fun getInput() {
        xMove = 0f
        yMove = 0f
        when {
            handler.getKeyManager().up -> {
                yMove = -speed
            }
            handler.getKeyManager().down -> {
                yMove = speed
            }
            handler.getKeyManager().left -> {
                xMove = -speed
            }
            handler.getKeyManager().right -> {
                xMove = speed
            }
        }
    }

    override fun render(g: Graphics) {
        g.drawImage(
            getCurrentAnimationFrame(),
            (x - handler.getGameCamera().xOffset).toInt(),
            (y - handler.getGameCamera().yOffset).toInt(),
            width,
            height,
            null
        )

        // DEBUG - bounding box
//        g.color = Color.PINK
//        g.fillRect(
//            (x + bounds.x - handler.getGameCamera().xOffset).toInt(),
//            (y + bounds.y - handler.getGameCamera().yOffset).toInt(),
//            bounds.width,
//            bounds.height
//        )
    }

    private fun getCurrentAnimationFrame(): BufferedImage? {

        Assets.playerUp[0]

        return when {
            xMove < 0 -> {
                animLeft.getCurrentFrame()
            }
            xMove > 0 -> {
                animRight.getCurrentFrame()
            }
            yMove < 0 -> {
                animUp.getCurrentFrame()
            }
            yMove > 0 -> {
                animDown.getCurrentFrame()
            }
            else -> {
                Assets.playerDown[0]
            }
        }
    }
}
