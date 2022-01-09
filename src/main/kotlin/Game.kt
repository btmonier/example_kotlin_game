import gfx.Display
import gfx.GameCamera
import input.KeyManager
import states.GameState
import states.MenuState
import states.State
import utilities.Constants
import utilities.FpsTimer
import utilities.Handler

class Game(
    var title: String,
    var width: Int,
    var height: Int,
) : Runnable {

    private var display: Display = Display(title, width, height)
    private var keyManager: KeyManager = KeyManager()
    private var thread: Thread? = null
    private var isRunning: Boolean = false
    private var fps = Constants.Window.FPS
    private var gameCamera: GameCamera? = null
    private var handler: Handler = Handler(this)

    init {
        start()
    }

    private fun initialize() {
        display.getFrame().addKeyListener(keyManager)
        display.getCanvas().addKeyListener(keyManager)
        gameCamera  = GameCamera(handler,0F, 0F)
        val menuState = MenuState(handler)
        val gameState = GameState(handler)
        State.state = gameState
    }

    private fun update() {
        keyManager.update()
        if (State.state != null) {
            State.state!!.update()
        }
    }

    private fun render() {
        // Triple buffer strategy (i.e. stop flickering in loop)
        val bs = display.getCanvas().bufferStrategy
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3)
            return
        }
        val g = bs.drawGraphics

        // Clear screen
        g.clearRect(0, 0, width, height)

        // Draw
        if (State.state != null) {
            State.state!!.render(g)
        }

        // Show graphics
        bs.show()
        g.dispose()
    }

    override fun run() {
        initialize()

        val timer = FpsTimer(fps)

        while (isRunning) {
            if (timer.check()) {
                update()
                render()
            }
        }
        stop()
    }

    fun getKeyManager(): KeyManager {
        return keyManager
    }

    fun getGameCamera(): GameCamera? {
        return gameCamera
    }

    @Synchronized
    fun start() {
        if (isRunning) return
        isRunning = true
        thread = Thread(this)
        thread!!.start()
    }

    @Synchronized
    fun stop() {
        if (!isRunning) return
        isRunning = false
        try {
            thread!!.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}

