package org.example

class RoverPosition {
    private var xx: Int = 0
    private var yy: Int = 0
    private var direction: Direction = Direction.North

    constructor(x: Int, y: Int, direction: Direction) {
        this.xx = x
        this.yy = y
        this.direction = direction
    }

    fun getCurrentPosition(): String {
        return "$xx $yy ${direction.shortName}"
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
            Direction.East -> moveRight()
            Direction.South -> moveDown()
            Direction.West -> moveLeft()
            Direction.North -> moveUp()
        }
    }

    private fun moveDown() {
        yy -= 1
    }

    private fun moveRight() {
        xx += 1
    }

    private fun moveUp() {
        yy += 1
    }

    private fun moveLeft() {
        xx -= 1
    }
}