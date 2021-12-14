fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontal_position = 0
        for (line: String in input) {
            val (direction, distance) = line.split(" ")
            when (direction) {
                "up" -> depth -= distance.toInt()
                "down" -> depth += distance.toInt()
                "forward" -> horizontal_position += distance.toInt()
            }
        }
        return depth * horizontal_position
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var horizontal_position = 0
        var aim = 0
        for (line: String in input) {
            val (direction, distance) = line.split(" ")
            when (direction) {
                "up" -> aim -= distance.toInt()
                "down" -> aim += distance.toInt()
                "forward" -> {
                    val dist = distance.toInt()
                    horizontal_position += dist
                    depth += aim * dist
                }
            }
        }
        return depth * horizontal_position
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
