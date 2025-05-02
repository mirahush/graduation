package org.example

import org.example.Direction.*

class Rover {
    private lateinit var position: RoverPosition

    constructor(p: String) {
        val startingPosition = p.split(' ')
        if (startingPosition.size >= 3) { // magic number, data clump
            this.position = RoverPosition(
                startingPosition[0].toInt(),
                startingPosition[1].toInt(),
                Direction.mapToDirection(startingPosition[2][0])
            )
        }
    }

    fun go(commands: String) {
        for (command in commands) {
            executeCommand(command)
        }
    }

    private fun executeCommand(command: Char) { // primitive obsession
        when (command) {
            'L' -> this.position.turnLeft()
            'R' -> this.position.turnRight()
            'M' -> this.position.move()
        }
    }

    fun getCurrentPosition(): String {
        return this.position.getCurrentPosition()
    }
}

class RoverPosition {
    private var xx: Int = 0
    private var yy: Int = 0
    private var direction: Direction = North

    constructor(x: Int, y: Int, direction: Direction) {
        this.xx = x
        this.yy = y
        this.direction = direction
    }

    fun getX(): Int {
        return xx
    }

    fun getY(): Int {
        return yy
    }

    fun getDirection(): Direction {
        return direction
    }

    fun getCurrentPosition(): String {
        return "$xx $yy ${direction.shortName}"
    }

    fun turnLeft() { // feature envy
        direction = Direction.whatIsOnTheLeftOf(direction)
    }

    fun turnRight() { // feature envy
        direction = Direction.whatIsOnTheRightOf(direction)
    }

    fun move() {
        when (direction) {
            East -> moveRight()
            South -> moveDown()
            West -> moveLeft()
            North -> moveUp()
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