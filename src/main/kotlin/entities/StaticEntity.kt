package entities

import utilities.Handler

abstract class StaticEntity(
    handler: Handler,
    x: Float,
    y: Float,
    width: Int,
    height: Int
) : Entity(handler, x, y, width, height)