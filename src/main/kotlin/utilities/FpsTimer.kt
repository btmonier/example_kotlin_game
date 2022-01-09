package utilities

class FpsTimer(fps: Int) {
    private val timePerUpdate = (1e9) / fps.toDouble()
    private var delta = 0.0
    private var now: Long = 0
    private var lastTime = System.nanoTime()

    fun check(): Boolean {
        now = System.nanoTime()
        delta = (now - lastTime) / timePerUpdate
        return if (delta >= 1) {
            lastTime = now
            true
        } else false
    }
}