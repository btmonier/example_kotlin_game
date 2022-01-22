package entities

import gfx.Animation
import gfx.Assets
import utilities.Constants
import utilities.Handler
import java.awt.Color
import java.awt.Graphics
import java.awt.Rectangle
import java.awt.image.BufferedImage

class Player(
    handler: Handler,
    x: Float = 100f,
    y: Float = 100f,
    private val animDown: Animation  = Animation(100, Assets.playerDown),
    private val animUp: Animation    = Animation(100, Assets.playerUp),
    private val animLeft: Animation  = Animation(100, Assets.playerLeft),
    private val animRight: Animation = Animation(100, Assets.playerRight),
    private var lastAttackTimer: Long = 800,
    private val attackCoolDown: Long = 800,
    private var attackTimer: Long = attackCoolDown
) : Creature(handler, x, y, Constants.Assets.DEFAULT_WIDTH, Constants.Assets.DEFAULT_HEIGHT) {

    private val debug = true

    init {
        bounds.x      = 6 * Constants.Assets.SCALE
        bounds.width  = 4 * Constants.Assets.SCALE
        bounds.y      = 7 * Constants.Assets.SCALE
        bounds.height = 8 * Constants.Assets.SCALE
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

        // Attack
        checkAttacks()
    }

    private fun checkAttacks() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer
        lastAttackTimer = System.currentTimeMillis()
        if (attackTimer < attackCoolDown) {
            return
        }


        val cb = getCollisionBounds(0F, 0F)
        val ar = Rectangle()
        val arSize = 20
        ar.width = arSize
        ar.height = arSize

        when {
            handler.getKeyManager().aUp -> {
                ar.x = cb.x + cb.width / 2 - arSize / 2
                ar.y = cb.y - arSize
            }
            handler.getKeyManager().aDown -> {
                ar.x = cb.x + cb.width / 2 - arSize / 2
                ar.y = cb.y + cb.height
            }
            handler.getKeyManager().aLeft -> {
                ar.x = cb.x - arSize
                ar.y = cb.y + cb.height / 2 - arSize / 2
            }
            handler.getKeyManager().aRight -> {
                ar.x = cb.x + cb.width
                ar.y = cb.y + cb.height / 2 - arSize / 2
            }
            else -> {
                return
            }
        }

        attackTimer = 0

        for (i in handler.world?.entityManager?.entities!!) {
            if (i == this) {
                continue
            }

            if (i.getCollisionBounds(0F, 0F).intersects(ar)) {
                i.hurt(1)
                return
            }
        }
    }

    private fun getInput() {
        xMove = 0f
        yMove = 0f
        if (handler.getKeyManager().up) {
            yMove = -speed
        }
        if (handler.getKeyManager().down) {
            yMove = speed
        }
        if (handler.getKeyManager().left) {
            xMove = -speed
        }
        if (handler.getKeyManager().right) {
            xMove = speed
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
        if (debug) {
            g.color = Color.BLUE
            g.fillRect(
                (x + bounds.x - handler.getGameCamera().xOffset).toInt(),
                (y + bounds.y - handler.getGameCamera().yOffset).toInt(),
                bounds.width,
                bounds.height
            )
        }

    }

    override fun die() {
        println("U ded...")
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
