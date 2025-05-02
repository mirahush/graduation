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

    fun go(cms: String) { // long method, duplicate code, feature envy
        for (c in cms) {
            when (c) {
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
    }

    private fun determineNextDirectionForMoveCommand() {
        when (position.dd) {
            'E' -> position.xx++
            'S' -> position.yy--
            'W' -> position.xx--
            'N' -> position.yy++
        }
    }

    private fun determineNextDirectionForRightCommand() {
        position.dd = whatIsOnTheRightOf(position.dd)
    }

    private fun determineNextDirectionForLeftCommand() {
        position.dd = whatIsOnTheLeftOf(position.dd)
    }

    private fun whatIsOnTheLeftOf(direction: Char): Char { // Primitive Obsession
        return when (direction) {
            'E' -> 'N'
            'N' -> 'W'
            'W' -> 'S'
            'S' -> 'E'
            else -> throw IllegalArgumentException("Invalid direction")
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
