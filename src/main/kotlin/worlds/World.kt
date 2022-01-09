package worlds

import entities.EntityManager
import entities.Player
import entities.Rock
import tiles.Tile
import utilities.Constants
import utilities.Handler
import utilities.Utils
import java.awt.Graphics
import kotlin.math.max
import kotlin.math.min

class World(
    private val handler: Handler,
    private val path: String,
    val entityManager: EntityManager = EntityManager(handler, Player(handler)),
    private val tokens: List<String> = Utils().loadFileAsString(path),
    val width: Int = tokens[0].toInt(),
    val height: Int = tokens[1].toInt(),
    spawnX: Float = tokens[2].toFloat(),
    spawnY: Float = tokens[3].toFloat(),
    private var tiles: Array<IntArray> = Array(width) { IntArray(height) }
) {

    init {
        loadWorld()
        entityManager.addEntity(
            Rock(
                handler,
                (Constants.Assets.DEFAULT_WIDTH * 4).toFloat(),
                (Constants.Assets.DEFAULT_HEIGHT * 4).toFloat(),
                Constants.Assets.DEFAULT_WIDTH,
                Constants.Assets.DEFAULT_HEIGHT
            )
        )
        entityManager.player.x = spawnX
        entityManager.player.y = spawnY
    }

    fun update() {
        entityManager.update()
    }

    fun render(g: Graphics) {
        val xStart = max(0, (handler.getGameCamera().xOffset / Constants.Assets.DEFAULT_WIDTH).toInt())
        val xEnd   = min(width, ((handler.getGameCamera().xOffset + handler.getWidth()) / Constants.Assets.DEFAULT_WIDTH).toInt() + 1)
        val yStart = max(0, (handler.getGameCamera().yOffset / Constants.Assets.DEFAULT_HEIGHT).toInt())
        val yEnd   = min(height, ((handler.getGameCamera().yOffset + handler.getHeight()) / Constants.Assets.DEFAULT_HEIGHT).toInt() + 1)

        for (i in yStart until yEnd) {
            for (j in xStart until xEnd) {
                getTile(j, i).render(
                    g,
                    (j * Constants.Assets.DEFAULT_WIDTH  - handler.getGameCamera().xOffset).toInt(),
                    (i * Constants.Assets.DEFAULT_HEIGHT - handler.getGameCamera().yOffset).toInt()
                )
            }
        }
        entityManager.render(g)
    }

    fun getTile(x: Int, y: Int): Tile {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile
        }
        return Tile.tiles[tiles[x][y]] ?: return Tile.grassTile
    }

    private fun loadWorld() {
        for (i in 0 until height) {
            for (j in 0 until width) {
                tiles[j][i] = tokens[(j + i * width) + Constants.Assets.N_METADATA].toInt()
            }
        }
    }
}


