package org.example

import org.example.Direction.*

class Rover {
    constructor(p: String) {
        val s = p.split(' ')
        if (s.size >= 3) { // magic number, data clump
            position.xx = s[0].toInt()
            position.yy = s[1].toInt()
            position.dd = s[2][0]
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
        var direction = Direction.map(position.dd) // Primitive Obsession
        when (direction) {
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

    private fun determineNextDirectionForRightCommand() {
        position.dd = whatIsOnTheRightOf(position.dd)
    }

    private fun determineNextDirectionForLeftCommand() {
        position.dd = whatIsOnTheLeftOf(position.dd)
    }

    private fun whatIsOnTheLeftOf(direction: Char): Char { // Primitive Obsession
        val mappedDirection = Direction.map(direction)
        return when (mappedDirection) {
            East -> Direction.map(North)
            North -> Direction.map(West)
            West -> Direction.map(South)
            South -> Direction.map(East)
        }
    }

    private fun whatIsOnTheRightOf(direction: Char): Char {
        val mappedDirection = Direction.map(direction)
        return when (mappedDirection) {
            East -> Direction.map(South)
            South -> Direction.map(West)
            West -> Direction.map(North)
            North -> Direction.map(East)
        }
    }

    fun getCurrentPosition(): String {
        return "${position.xx} ${position.yy} ${position.dd}"
    }

    private var position = RoverPosition()
}

class RoverPosition {
    var xx: Int = 0
    var yy: Int = 0
    var dd: Char = 'N'
}
