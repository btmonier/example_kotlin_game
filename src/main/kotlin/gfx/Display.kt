package gfx

import utilities.Constants
import java.awt.Canvas
import java.awt.Dimension
import javax.swing.ImageIcon
import javax.swing.JFrame

class Display(
    title: String,
    private val width: Int,
    private val height: Int
) {
    private val frame = JFrame(title)
    private val canvas = Canvas()

    init {
        createDisplay()
    }

    private fun createDisplay() {
        // Set up frame object
        frame.setSize(width, height)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.isResizable = false
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
        frame.iconImage = ImageIcon(Constants.Window.ICON_PATH).image

        // Set up canvas
        canvas.preferredSize = Dimension(width, height)
        canvas.maximumSize = Dimension(width, height)
        canvas.minimumSize = Dimension(width, height)
        canvas.isFocusable = false

        // Load canvas into frame
        frame.add(canvas)
        frame.pack()
    }

    fun getCanvas(): Canvas {
        return canvas
    }

    fun getFrame(): JFrame {
        return frame
    }
}