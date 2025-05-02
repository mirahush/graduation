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

    private fun getX(): Int {
        return xx
    }

    private fun getY(): Int {
        return yy
    }

    fun getCurrentPosition(): String {
        return "$xx $yy ${direction.shortName}"
    }

    fun executeCommand(command: Char) { // primitive obsession
        when (command) {
            'L' -> turnLeft()
            'R' -> turnRight()
            'M' -> move()
        }
    }

    private fun turnLeft() { // feature envy
        direction = Direction.whatIsOnTheLeftOf(direction)
    }

    private fun turnRight() { // feature envy
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
        yy = this.getY() - 1
    }

    private fun moveRight() {
        xx = this.getX() + 1
    }

    private fun moveUp() {
        yy = this.getY() + 1
    }

    private fun moveLeft() {
        xx = this.getX() - 1
    }
}