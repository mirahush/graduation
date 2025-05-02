package org.example

class Rover {
    constructor(p: String) {
        val s = p.split(' ')
        if (s.size >= 3) { // magic number
            position.xx = s[0].toInt()
            position.yy = s[1].toInt()
            position.dd = s[2][0]
        }
    }

    fun go(cms: String) {
        for (c in cms) {
            when (c) {
                'L' -> {
                    when (position.dd) {
                        'E' -> position.dd = 'N'
                        'N' -> position.dd = 'W'
                        'W' -> position.dd = 'S'
                        'S' -> position.dd = 'E'
                    }
                }

                'R' -> {
                    when (position.dd) {
                        'E' -> position.dd = 'S'
                        'S' -> position.dd = 'W'
                        'W' -> position.dd = 'N'
                        'N' -> position.dd = 'E'
                    }
                }

                'M' -> {
                    when (position.dd) {
                        'E' -> position.xx++
                        'S' -> position.yy--
                        'W' -> position.xx--
                        'N' -> position.yy++
                    }
                }
            }
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
