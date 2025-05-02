package org.example

enum class Direction {
    East(),
    West(),
    North(),
    South();

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

        fun mapToChar(direction: Direction): Char {
            return when (direction) {
                North -> 'N'
                West -> 'W'
                South -> 'S'
                East -> 'E'
            }
        }

        fun whatIsOnTheLeftOf(direction: Char): Char { // Primitive Obsession
            val mappedDirection = Direction.mapToDirection(direction)
            return when (mappedDirection) {
                East -> Direction.mapToChar(North)
                North -> Direction.mapToChar(West)
                West -> Direction.mapToChar(South)
                South -> Direction.mapToChar(East)
            }
        }

        fun whatIsOnTheRightOf(direction: Char): Char {
            val mappedDirection = Direction.mapToDirection(direction)
            return when (mappedDirection) {
                East -> Direction.mapToChar(South)
                South -> Direction.mapToChar(West)
                West -> Direction.mapToChar(North)
                North -> Direction.mapToChar(East)
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