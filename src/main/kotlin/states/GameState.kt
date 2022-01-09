package states

import utilities.Constants
import utilities.Handler
import worlds.World
import java.awt.Graphics


class GameState(handler: Handler) : State() {
    private val world: World = World(handler, Constants.Assets.WORLD_PATH)

    init {
        handler.world = world
    }

    override fun update() {
        world.update()
    }

    override fun render(g: Graphics) {
        world.render(g)
    }
}