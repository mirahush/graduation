package org.example

class Coordinate(val x: Int, val y: Int) {
    fun updateX(newX: Int): Coordinate {
        return Coordinate(newX, y)
    }

    fun updateY(newY: Int): Coordinate {
        return Coordinate(x, newY)
    }
}