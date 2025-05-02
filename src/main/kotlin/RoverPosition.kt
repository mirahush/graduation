package org.example

import org.example.Direction.*

class RoverPosition {
    private var coordinate: Coordinate
    private var direction: Direction = North

    constructor(x: Int, y: Int, direction: Direction) {
        this.coordinate = Coordinate(x, y)
        this.direction = direction
    }

    fun getCurrentPosition(): String {
        return "$coordinate ${direction.shortName}"
    }

    fun executeCommand(command: Char) {
        when (command) {
            'L' -> turnLeft()
            'R' -> turnRight()
            'M' -> move()
        }
    }

    private fun turnLeft() {
        direction = Direction.whatIsOnTheLeftOf(direction)
    }

    private fun turnRight() {
        direction = Direction.whatIsOnTheRightOf(direction)
    }

    private fun move() {
        coordinate = when (direction) {
            East -> coordinate.moveRight()
            South -> coordinate.moveDown()
            West -> coordinate.moveLeft()
            North -> coordinate.moveUp()
        }
    }
}