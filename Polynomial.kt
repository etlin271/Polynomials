/*
* add
* multiply
* differentiate
* string representation
* equality
 */
class Polynomial(private val coefficients: List<Int>) {
    fun string(): String {
        var string = ""
        coefficients.forEachIndexed { index, i ->
            println(coefficients[index])
            if(index != 0 && index != coefficients.lastIndex && i > 0) {
                val term = " + ${i}x^$index"
                string = term + string
            }
            else if (index != 0 && index == coefficients.lastIndex && i > 0) {
                val term = "${i}x^$index"
                string = term + string
            }
            else if (index != 0 && index != coefficients.lastIndex && i < 0) {
                val term = " - ${i}x^$index"
                string = term + string
            }
            else if (index != 0 && index == coefficients.lastIndex && i < 0) {
                val term = "${i}x^$index"
                string = term + string
            }
            else if (index == 0 && i > 0) {
                val term = " + $i"
                string = term + string
            }
            else if (index == 0 && i < 0) {
                val term = " - $i"
                string = term + string
            }
        }
        return string
    }

    fun plus(other: Polynomial): Polynomial {
        val sumCoefficients = mutableListOf<Int>()
        if(coefficients.size > other.coefficients.size) {
            coefficients.forEachIndexed { index, i ->
                sumCoefficients.add(i + other.coefficients[index])
            }
        }
        else {
            other.coefficients.forEachIndexed { index, i ->
                sumCoefficients.add(i + coefficients[index])
            }
        }
        val sum = Polynomial(sumCoefficients)
        return sum
    }
}

fun main() {
    val x = Polynomial(listOf(1, 1, 1))
    println(x.string())
    val y = Polynomial(listOf(1, 1, 1))
    println(x.string())
    println((x.plus(y)).string())
}
