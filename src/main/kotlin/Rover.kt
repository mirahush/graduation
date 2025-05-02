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
            'L' -> turnLeft()
            'R' -> turnRight()
            'M' -> move()
        }
    }

    private fun move() {
        when (position.getDirection()) {
            East -> this.position.moveRight()
            South -> this.position.moveDown()
            West -> this.position.moveLeft()
            North -> this.position.moveUp()
        }
    }

    private fun turnRight() { // feature envy
        this.position.setDirection(Direction.whatIsOnTheRightOf(position.getDirection()))
    }

    private fun turnLeft() { // feature envy
        this.position.setDirection(Direction.whatIsOnTheLeftOf(position.getDirection()))
    }

    fun getCurrentPosition(): String {
        return "${position.getX()} ${position.getY()} ${position.getDirection().shortName}"
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

    fun setDirection(direction: Direction) {
        this.direction = direction
    }

    fun moveDown() {
        yy = this.getY() - 1
    }

    fun moveRight() {
        xx = this.getX() + 1
    }

    fun moveUp() {
        yy = this.getY() + 1
    }

    fun moveLeft() {
        xx = this.getX() - 1
    }
}