package org.example

class Rover {
    private var position: RoverPosition

    constructor(startingPosition: String) {
        val parsedStartingPosition = parseStartingPosition(startingPosition)
        position = RoverPosition(
            parsedStartingPosition.first,
            parsedStartingPosition.second,
            parsedStartingPosition.third
        )
    }

    private fun parseStartingPosition(p: String): Triple<Int, Int, Direction> {
        val startingPosition = p.split(' ')
        if (startingPosition.size < 3) {
            throw RuntimeException("Invalid starting position. Less than 3 arguments are provided. Unable to determine the rover's position.")
        }
        return Triple(
            startingPosition[0].toInt(),
            startingPosition[1].toInt(),
            Direction.mapToDirection(startingPosition[2][0])
        )
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