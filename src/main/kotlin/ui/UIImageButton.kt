package ui

import java.awt.Graphics
import java.awt.image.BufferedImage

class UIImageButton(
    x: Float,
    y: Float,
    width: Int,
    height: Int,
    val images: List<BufferedImage?>,
    val clicker: ClickListener
) : UIObject(x, y, width, height) {

    override fun update() {}

    override fun render(g: Graphics) {
        if (hovering) {
            g.drawImage(images[1], x.toInt(), y.toInt(), width, height, null)
        } else {
            g.drawImage(images[0], x.toInt(), y.toInt(), width, height, null)
        }
    }

    override fun onClick() {
        clicker.onClick()
    }
}