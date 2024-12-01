import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import kotlin.math.abs


class Day01 {

    private val day = "Day01"

    @Test
    fun testSolution1() {
        assertThat(solution1(readInput("${day}_test"))).isEqualTo(11)
    }

    @Test
    fun solution1() {
        assertThat(solution1(readInput(day))).isEqualTo(1258579)
    }

    @Test
    fun testSolution2() {
        assertThat(solution2(readInput("${day}_test"))).isEqualTo(31)
    }

    @Test
    fun solution2() {
        assertThat(solution2(readInput(day))).isEqualTo(23981443)
    }

    private fun solution1(input: List<String>): Int {
        val listLeft = mutableListOf<Int>()
        val listRight = mutableListOf<Int>()

        input.forEach { string ->
            string.split(" ").filter { it.isNotBlank() }.let { numbers ->
                listLeft.add(numbers[0].toInt())
                listRight.add(numbers[1].toInt())
            }
        }
        listLeft.sort()
        listRight.sort()

        var result = 0

        listLeft.forEachIndexed { index, i ->
            result += abs(listLeft[index] - listRight[index])
        }

        return result

    }

    private fun solution2(input: List<String>): Int {
        val listLeft = mutableListOf<Int>()
        val listRight = mutableListOf<Int>()

        input.forEach { string ->
            string.split(" ").filter { it.isNotBlank() }.let { numbers ->
                listLeft.add(numbers[0].toInt())
                listRight.add(numbers[1].toInt())
            }
        }

        var result = 0
        listLeft.forEach { leftNb ->
            var count = leftNb * listRight.count { rightNb -> rightNb == leftNb }
            result += count
        }


        return result
    }


}
