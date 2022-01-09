package utilities

import Game
import gfx.GameCamera
import input.KeyManager
import worlds.World

class Handler(private var game: Game, var world: World? = null) {

    fun getWidth(): Int {
        return game.width
    }

    fun getHeight(): Int {
        return game.height
    }

    fun getKeyManager(): KeyManager {
        return game.getKeyManager()
    }

    fun getGameCamera(): GameCamera {
        return game.getGameCamera()!!
    }
}