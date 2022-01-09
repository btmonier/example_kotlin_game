package entities

import utilities.Handler
import java.awt.Graphics

class EntityManager(
    val handler: Handler,
    val player: Player,
    private val entities: ArrayList<Entity> = ArrayList(),
) {
    fun update() {
        for (i in entities) {
            i.update()
        }
        player.update()
    }

    fun render(g: Graphics) {
        for (i in entities) {
            i.render(g)
        }
        player.render(g)
    }

    fun addEntity(e: Entity) {
        entities.add(e)
    }
}