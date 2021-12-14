import jdk.jfr.Threshold

fun main() {
    fun binaryFromCounts(counts: List<Int>, func: (Int) -> Boolean): String {
        return counts.map { if (func(it)) 1 else 0 }.joinToString("")
    }

    fun bin2dec(binary: String): Int {
        return binary.map { it.toString().toInt() }.fold(0) { acc, i -> acc * 2 + i }
    }

    fun part1(input: List<String>): Int {
        val countOfOnes: MutableList<Int> = MutableList(input[0].length) { 0 }
        for (line: String in input) {
            for ((index: Int, digit: Char) in line.withIndex()) {
                if (digit == '1') {
                    countOfOnes.set(index, countOfOnes[index] + 1)
                }
            }
        }
        val gamma = binaryFromCounts(countOfOnes) { it >= input.size / 2 }
        val epsilon = binaryFromCounts(countOfOnes) { it < input.size / 2 }
        return bin2dec(gamma) * bin2dec(epsilon)
    }

    fun findByBitCriteria(input: List<String>, func: (Int, Int) -> Boolean): String {
        var index = 0
        var left = input.toList()
        while (left.size > 1) {
            var countOfOnes = 0
            for (i: String in left) {
                if (i[index] == '1') {
                    countOfOnes++
                }
            }
            val match = if (func(countOfOnes, left.size)) '1' else '0'
            left = left.filter { it[index] == match }
            index += 1
        }
        return left[0]
    }

    fun part2(input: List<String>): Int {
        val oxygen = findByBitCriteria(input) { a, b -> 2 * a >= b }
        val co2 = findByBitCriteria(input) { a, b -> 2 * a < b }
        return bin2dec(oxygen) * bin2dec(co2)
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
