package gfx

import java.awt.image.BufferedImage

class Animation(
    private val speed: Int,
    private val frames: List<BufferedImage?>,
    private var index: Int = 0,
    private var lastTime: Long = System.currentTimeMillis(),
    private var timer: Long = 0
) {
    fun update() {
        timer += System.currentTimeMillis() - lastTime
        lastTime = System.currentTimeMillis()

        if (timer > speed) {
            index++
            timer = 0
            if (index >= frames.size) {
                index = 0
            }
        }
    }

    fun getCurrentFrame(): BufferedImage? {
        return frames[index]
    }
}