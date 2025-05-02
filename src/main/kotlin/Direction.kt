package org.example

enum class Direction(var shortName: Char) {
    East('E'),
    West('W'),
    North('N'),
    South('S');

    companion object {
        fun mapToDirection(direction: Char): Direction {
            return when (direction) {
                'N' -> North
                'W' -> West
                'S' -> South
                'E' -> East
                else -> throw IllegalArgumentException("Invalid direction")
            }
        }

        fun whatIsOnTheLeftOf(direction: Direction): Direction {
            return when (direction) {
                East -> North
                North -> West
                West -> South
                South -> East
            }
        }

        fun whatIsOnTheRightOf(direction: Direction): Direction {
            return when (direction) {
                East -> South
                South -> West
                West -> North
                North -> East
            }
        }
    }
}