package gfx

import utilities.Constants

class Assets {
    companion object {
        private const val width: Int = Constants.Assets.SPRITE_DIM_X
        private const val height: Int = Constants.Assets.SPRITE_DIM_Y
        private val sheet: SpriteSheet = SpriteSheet(ImageLoader().loadImage(Constants.Assets.ASSET_PATH))

        // Animations
        val playerDown = listOf(
            sheet.crop(width * 0, 0, width, height),
            sheet.crop(width * 1, 0, width, height),
            sheet.crop(width * 0, 0, width, height),
            sheet.crop(width * 2, 0, width, height)
        )
        val playerRight = listOf(
            sheet.crop(width * 3, 0, width, height),
            sheet.crop(width * 4, 0, width, height)
        )
        val playerUp = listOf(
            sheet.crop(width * 5, 0, width, height),
            sheet.crop(width * 6, 0, width, height),
            sheet.crop(width * 5, 0, width, height),
            sheet.crop(width * 7, 0, width, height)
        )
        val playerLeft = listOf(
            sheet.crop(width * 8, 0, width, height),
            sheet.crop(width * 9, 0, width, height)
        )
        val btnStart = listOf(
            sheet.crop(width * 0, height * 4, width * 2, height),
            sheet.crop(width * 2, height * 4, width * 2, height)
        )

        // Static entities
        val rock = sheet.crop(width * 4, height * 3, width, height)

        // Tiles
        val desert = sheet.crop(0, height * 2, width, height)
        val grass  = sheet.crop(0, 48, width, height)
        val brick  = sheet.crop(width * 1, height * 2, width, height)
    }
}