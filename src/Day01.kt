fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        var last = input[0].toInt()
        for (line: String in input.drop(1)) {
            val current = line.toInt()
            if (current > last) {
                count += 1
            }
            last = current
        }
        return count
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
