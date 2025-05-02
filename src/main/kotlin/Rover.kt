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

    private fun parseStartingPosition(startingPosition: String): Triple<Int, Int, Direction> {
        val splittedStartingPosition = startingPosition.split(' ')

        if (splittedStartingPosition.size < 3) {
            throw RuntimeException("Invalid starting position. Less than 3 arguments are provided. Unable to determine the rover's position.")
        }

        return Triple(
            splittedStartingPosition[0].toInt(),
            splittedStartingPosition[1].toInt(),
            Direction.mapToDirection(splittedStartingPosition[2][0])
        )
    }

    fun go(commands: String) {
        for (command in commands) {
            position.executeCommand(command)
        }
    }

    fun getCurrentPosition(): String {
        return position.getCurrentPosition()
    }
}