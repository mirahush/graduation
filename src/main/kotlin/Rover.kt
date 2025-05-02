package org.example

import org.example.Direction.*

class Rover {
    constructor(p: String) {
        val s = p.split(' ')
        if (s.size >= 3) { // magic number, data clump
            position.xx = s[0].toInt()
            position.yy = s[1].toInt()
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
        position.yy--
    }

    private fun moveUp() {
        position.yy++
    }

    private fun moveLeft() {
        position.xx--
    }

    private fun moveRight() {
        position.xx++
    }

    private fun determineNextDirectionForRightCommand() { // feature envy
        this.position.setDirection(Direction.whatIsOnTheRightOf(position.getDirection()))
    }

    private fun determineNextDirectionForLeftCommand() { // feature envy
        this.position.setDirection(Direction.whatIsOnTheLeftOf(position.getDirection()))
    }

    fun getCurrentPosition(): String {
        return "${position.xx} ${position.yy} ${position.getDirection().shortName}"
    }

    private var position = RoverPosition()
}

class RoverPosition {
    var xx: Int = 0
    var yy: Int = 0
    private var direction: Direction = North

    fun getDirection(): Direction {
        return direction
    }

    fun setDirection(direction: Direction) {
        this.direction = direction
    }
}