package tiles

import gfx.Assets

class BrickTile(id: Int) : Tile(Assets.brick, id) {
    override fun isSolid(): Boolean {
        return true
    }
}