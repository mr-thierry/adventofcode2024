import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import kotlin.math.abs


class Day02 {

    private val day = "Day02"

    @Test
    fun testSolution1() {
        assertThat(solution1(readInput("${day}_test"))).isEqualTo(2)
    }

    @Test
    fun solution1() {
        assertThat(solution1(readInput(day))).isEqualTo(598)
    }

    @Test
    fun testSolution2() {
        assertThat(solution2(readInput("${day}_test"))).isEqualTo(4)
    }

    @Test
    fun solution2() {
        assertThat(solution2(readInput(day))).isEqualTo(634)
    }

    private fun solution2(input: List<String>): Int {
        var result = 0

        input.forEach { string ->
            val numbersOrig  = string.split(" ").map { it.toInt() }


            val allIncreasingOrDecreasing = allIncreasingOrDecreasing(numbersOrig)
            val noExceedThreshold = noExceedThreshold(numbersOrig)

            if (allIncreasingOrDecreasing && noExceedThreshold) {
                result++
            } else {
                var validCount = 0
                for (i in 0 until numbersOrig.size) {
                    val numbers = numbersOrig.removeAt(i)

                    val allIncreasingOrDecreasing = allIncreasingOrDecreasing(numbers)
                    val noExceedThreshold = noExceedThreshold(numbers)

                    if (allIncreasingOrDecreasing && noExceedThreshold) {
                        validCount++
                    }
                }

                if (validCount > 0) {
                    result ++
                }
            }
        }

        return result
    }

    private fun List<Int>.removeAt(index: Int): MutableList<Int> {
        val numbers = this.toMutableList()
        numbers.removeAt(index)
        return numbers
    }

    private fun allIncreasingOrDecreasing(numbers: List<Int>): Boolean {
        val allIncreasingOrDecreasing = ((numbers.sorted() == numbers) || (numbers.sortedDescending() == numbers))
                && numbers.distinct().count() == numbers.count()
        return allIncreasingOrDecreasing
    }

    private fun noExceedThreshold(numbers: List<Int>): Boolean {
        var valid = true
        numbers.forEachIndexed { index, i ->
            if (index > 0) {
                val previous = numbers[index - 1]
                val current = numbers[index]
                if (abs(current - previous) > 3) {
                    valid = false
                }
            }
        }
        return valid
    }

    //////////////////////////////////////////////////

    private fun solution1(input: List<String>): Int {
        var result = 0

        input.forEach { string ->
            val numbers = string.split(" ").map { it.toInt() }

            val allIncreasingOrDecreasing = ((numbers.sorted() == numbers) || (numbers.sortedDescending() == numbers))
                    && numbers.distinct().count() == numbers.count()

            var valid = noExceedThreshold(numbers)

            if (allIncreasingOrDecreasing && valid) {
                result++
            }
        }

        return result

    }


}
