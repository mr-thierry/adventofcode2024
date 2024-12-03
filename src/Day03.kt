import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test


class Day03Unit {

    private val day = "Day03"

    @Test
    fun testSolution1() {
        assertThat(solution(readInput("${day}_test"))).isEqualTo(161)
    }

    @Test
    fun solution1() {
        assertThat(solution(readInput(day))).isEqualTo(187833789)
    }

    @Test
    fun testSolution2() {
        assertThat(solution(readInput("${day}_test"))).isEqualTo(48)
    }

    @Test
    fun solution2() {
        //65511348 to low
        //96153039 to high
        assertThat(solution(readInput(day))).isEqualTo(0)
    }

    private fun solution(input: List<String>): Int {
        var str = input.joinToString()

        var result = 0
        var done = false

        while (!done) {
            val index = str.indexOf("mul(")
            var nextDont = str.indexOfWithMax("don't()")

            if (nextDont < index) {
                var nextDo = str.indexOfWithMax("do()")
                if (nextDo == Int.MAX_VALUE) {
                    done = true
                } else {
                    str = str.substring(nextDo + "do()".length)
                }

            }  else {
                if (index > -1) {
                    str = str.substring(index + "mul(".length)

                    val indexParenthesis = str.indexOf(")")
                    if (indexParenthesis > -1) {
                        val indexNextMul = str.indexOf("mul")
                        if (indexParenthesis < indexNextMul || indexNextMul == -1) {
                            val content = str.substring(0, indexParenthesis)

                            val commaIdx = content.indexOf(",")
                            if (commaIdx > -1) {
                                val first = str.substring(0, commaIdx)
                                val second = str.substring(commaIdx + 1, indexParenthesis)

                                result = result + mul(first, second)
                            }

                            str = str.substring(indexParenthesis + 1)
                        } else if (indexNextMul > -1) {
                            str = str.substring(indexNextMul)
                        }
                    }
                } else {
                    done = true
                }
            }
        }
        return result
    }

    private fun String.indexOfWithMax(string: String): Int {
        val index = indexOf(string)
        if (index == -1) {
            return Int.MAX_VALUE
        } else {
            return index
        }
    }

    private fun mul(first: String, second: String): Int {
        try {
            return first.toInt() * second.toInt()
        } catch (_: Exception) {
            return 0
        }
    }


}
