package entities

import utilities.Constants
import utilities.Handler
import java.awt.Graphics


abstract class Creature(
    handler: Handler,
    x: Float,
    y: Float,
    width: Int,
    height: Int,
) : Entity(handler, x, y, width, height) {

    val speed = Constants.Entity.DEFAULT_SPEED
    val health = Constants.Entity.DEFAULT_HEALTH
    protected var xMove = 0f
    protected var yMove = 0f

    fun move() {
        if (!checkEntityCollisions(xMove, 0f)) {
            moveX()
        }
        if (!checkEntityCollisions(0f, yMove)) {
            moveY()
        }
    }

    private fun moveX() {
        if (xMove > 0) {
            val tx: Int = (x + xMove + bounds.x + bounds.width).toInt() / Constants.Assets.DEFAULT_WIDTH
            if (!collisionWithTile(tx, ((y + bounds.y) / Constants.Assets.DEFAULT_HEIGHT).toInt()) &&
                !collisionWithTile(tx, ((y + bounds.y + bounds.height) / Constants.Assets.DEFAULT_HEIGHT).toInt())
            ) {
                x += xMove
            } else {
                x = (tx * Constants.Assets.DEFAULT_WIDTH - bounds.x - bounds.width - 1).toFloat()
            }
        } else if (xMove < 0) {
            val tx: Int = (x + xMove + bounds.x).toInt() / Constants.Assets.DEFAULT_WIDTH
            if (!collisionWithTile(tx, ((y + bounds.y) / Constants.Assets.DEFAULT_HEIGHT).toInt()) &&
                !collisionWithTile(tx, ((y + bounds.y + bounds.height) / Constants.Assets.DEFAULT_HEIGHT).toInt())
            ) {
                x += xMove
            } else {
                x = (tx * Constants.Assets.DEFAULT_WIDTH + Constants.Assets.DEFAULT_WIDTH - bounds.x).toFloat()
            }
        }
    }

    private fun moveY() {
        if (yMove < 0) {
            val ty: Int = (y + yMove + bounds.y).toInt() / Constants.Assets.DEFAULT_HEIGHT
            if (!collisionWithTile(((x + bounds.x) / Constants.Assets.DEFAULT_WIDTH).toInt(), ty) &&
                !collisionWithTile(((x + bounds.x + bounds.width) / Constants.Assets.DEFAULT_WIDTH).toInt(), ty)
            ) {
                y += yMove
            } else {
                y = (ty * Constants.Assets.DEFAULT_HEIGHT + Constants.Assets.DEFAULT_HEIGHT - bounds.y).toFloat()
            }
        } else if (yMove > 0) {
            val ty: Int = (y + yMove + bounds.y + bounds.height).toInt() / Constants.Assets.DEFAULT_HEIGHT
            if (!collisionWithTile(((x + bounds.x) / Constants.Assets.DEFAULT_WIDTH).toInt(), ty) &&
                !collisionWithTile(((x + bounds.x + bounds.width) / Constants.Assets.DEFAULT_WIDTH).toInt(), ty)
            ) {
                y += yMove
            } else {
                y = (ty * Constants.Assets.DEFAULT_HEIGHT - bounds.y - bounds.height - 1).toFloat()
            }
        }
    }

    private fun collisionWithTile(x: Int, y: Int) : Boolean {
        return handler.world!!.getTile(x, y).isSolid()
    }

    override fun update() {}
    override fun render(g: Graphics) {}
}