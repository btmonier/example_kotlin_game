package entities

import utilities.Handler
import java.awt.Graphics


class EntityManager(
    val handler: Handler,
    val player: Player,
    val entities: ArrayList<Entity> = ArrayList(),
    private val renderSorter: Comparator<Entity> = Comparator { a, b ->
        if (a.y + a.height < b.y + b.height) -1 else 1
    }
) {

    init {
        addEntity(player)
    }

    fun update() {
        for (i in entities) {
            i.update()
            if (!i.active) {
                entities.remove(i)
            }
        }
        entities.sortWith(renderSorter)
    }

    fun render(g: Graphics) {
        for (i in entities) {
            i.render(g)
        }
    }

    fun addEntity(e: Entity) {
        entities.add(e)
    }
}