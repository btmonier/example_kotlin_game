package tiles

import utilities.Constants
import java.awt.Graphics
import java.awt.image.BufferedImage

@Suppress("LeakingThis")
open class Tile(texture: BufferedImage?, id: Int) {
    private var texture: BufferedImage
    private val id: Int

    fun update() {}

    fun render(g: Graphics, x: Int, y: Int) {
        g.drawImage(texture, x, y, Constants.Assets.DEFAULT_WIDTH, Constants.Assets.DEFAULT_HEIGHT, null)
    }

    open fun isSolid(): Boolean {
        return false
    }

    fun getId(): Int {
        return id
    }

    companion object {
        var tiles = arrayOfNulls<Tile>(256)
        var grassTile: Tile = GrassTile(0)
        var brickTile: Tile = BrickTile(1)
    }

    init {
        this.texture = texture!!
        this.id = id
        tiles[id] = this
    }
}