package org.example

class Coordinate(private val x: Int, private val y: Int) {

    override fun toString(): String {
        return "$x $y"
    }

    fun moveLeft(): Coordinate = updateX(x - 1)

    fun moveRight(): Coordinate = updateX(x + 1)

    fun moveUp(): Coordinate = updateY(y + 1)

    fun moveDown(): Coordinate = updateY(y - 1)

    private fun updateX(newX: Int): Coordinate {
        return Coordinate(newX, y)
    }

    private fun updateY(newY: Int): Coordinate {
        return Coordinate(x, newY)
    }
}