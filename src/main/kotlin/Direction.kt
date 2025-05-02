package org.example

enum class Direction {
    East(),
    West(),
    North(),
    South();

    companion object {
        fun map(direction: Char): Direction {
            return when (direction) {
                'N' -> North
                'W' -> West
                'S' -> South
                'E' -> East
                else -> throw IllegalArgumentException("Invalid direction")
            }
        }
        fun map(direction: Direction): Char {
            return when (direction) {
                North -> 'N'
                West -> 'W'
                South -> 'S'
                East -> 'E'
            }
        }
    }

}