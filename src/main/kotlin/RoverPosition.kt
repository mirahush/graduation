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
        return "${coordinate.x} ${coordinate.y} ${direction.shortName}"
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
        when (direction) {
            East -> moveRight()
            South -> moveDown()
            West -> moveLeft()
            North -> moveUp()
        }
    }

    private fun moveLeft() {
        coordinate = coordinate.updateX(coordinate.x - 1)
    }

    private fun moveRight() {
        coordinate = coordinate.updateX(coordinate.x + 1)
    }

    private fun moveUp() {
        coordinate = coordinate.updateY(coordinate.y + 1)
    }

    private fun moveDown() {
        coordinate = coordinate.updateY(coordinate.y - 1)
    }
}