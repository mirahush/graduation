package org.example

import org.example.Direction.*

class Rover {
    constructor(p: String) {
        val s = p.split(' ')
        if (s.size >= 3) { // magic number, data clump
            this.position.setX(s[0].toInt())
            this.position.setY(s[1].toInt())
            this.position.setDirection(Direction.mapToDirection(s[2][0]))
        }
    }

    fun go(commands: String) {
        for (command in commands) {
            executeCommand(command)
        }
    }

    private fun executeCommand(command: Char) { // primitive obsession
        when (command) {
            'L' -> {
                determineNextDirectionForLeftCommand()
            }

            'R' -> {
                determineNextDirectionForRightCommand()
            }

            'M' -> {
                determineNextDirectionForMoveCommand()
            }
        }
    }

    private fun determineNextDirectionForMoveCommand() {
        when (position.getDirection()) {
            East -> moveRight()
            South -> moveDown()
            West -> moveLeft()
            North -> moveUp()
        }
    }

    private fun moveDown() {
        this.position.setY(this.position.getY() - 1)
    }

    private fun moveUp() {
        this.position.setY(this.position.getY() + 1)
    }

    private fun moveLeft() {
        this.position.setX(this.position.getX() - 1)
    }

    private fun moveRight() {
        this.position.setX(this.position.getX() + 1)
    }

    private fun determineNextDirectionForRightCommand() { // feature envy
        this.position.setDirection(Direction.whatIsOnTheRightOf(position.getDirection()))
    }

    private fun determineNextDirectionForLeftCommand() { // feature envy
        this.position.setDirection(Direction.whatIsOnTheLeftOf(position.getDirection()))
    }

    fun getCurrentPosition(): String {
        return "${position.getX()} ${position.getY()} ${position.getDirection().shortName}"
    }

    private var position = RoverPosition()
}

class RoverPosition {
    private var xx: Int = 0
    private var yy: Int = 0
    private var direction: Direction = North

    fun getX(): Int {
        return xx
    }

    fun setX(x: Int) {
        this.xx = x
    }

    fun getY(): Int {
        return yy
    }

    fun setY(y: Int) {
        this.yy = y
    }

    fun getDirection(): Direction {
        return direction
    }

    fun setDirection(direction: Direction) {
        this.direction = direction
    }
}