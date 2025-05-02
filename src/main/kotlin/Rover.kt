package org.example

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
            Direction.East -> moveRight()
            Direction.South -> moveDown()
            Direction.West -> moveLeft()
            Direction.North -> moveUp()
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
            Direction.East -> Direction.map(Direction.North)
            Direction.North -> Direction.map(Direction.West)
            Direction.West -> Direction.map(Direction.South)
            Direction.South -> Direction.map(Direction.East)
        }
    }

    private fun whatIsOnTheRightOf(direction: Char): Char {
        return when (direction) {
            'E' -> 'S'
            'S' -> 'W'
            'W' -> 'N'
            'N' -> 'E'
            else -> throw IllegalArgumentException("Invalid direction")
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
