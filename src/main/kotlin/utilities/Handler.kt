package utilities

import Game
import gfx.GameCamera
import input.KeyManager
import input.MouseManager
import worlds.World

class Handler(var game: Game, var world: World? = null) {
    fun getWidth(): Int {
        return game.width
    }

    fun getHeight(): Int {
        return game.height
    }

    fun getKeyManager(): KeyManager {
        return game.keyManager
    }

    fun getMouseManager(): MouseManager {
        return game.mouseManager
    }

    fun getGameCamera(): GameCamera {
        return game.getGameCamera()!!
    }
}