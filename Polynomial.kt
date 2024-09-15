/*
* add
* multiply
* differentiate
* string representation
* equality
 */
class Polynomial(private val coefficients: List<Int>) {
    override fun toString(): String {
        val terms = coefficients.indices
            .reversed()
            .mapNotNull { i ->
                val coefficient = coefficients[i]
                if (coefficient >= 0){
                    when {
                        coefficient == 0 -> null 
                        i == 0 -> coefficient.toString()
                        i == 1 -> "${if (coefficient != 1) coefficient else ""}x"
                        else -> "${if (coefficient != 1) coefficient else ""}x^$i"
                    }
                }
                else {
                    when (i) {
                        0 -> "-$coefficient"
                        1 -> "${if (coefficient != -1) "$coefficient" else "-"}x"
                        else -> "${if (coefficient != -1) "$coefficient" else "-"}x^$i"
                    }
                }
            } 
            .joinToString(separator = " ") { term ->
                if (term.startsWith("-")) "- ${term.removePrefix("-")}"
                else "+ $term"
            }
            .removePrefix("+ ")

        return terms.ifEmpty { "0" }
    }

    operator fun plus(other: Polynomial): Polynomial {
        val sumCoefficients = mutableListOf<Int>()
        if (coefficients.size > other.coefficients.size) {
            coefficients.forEachIndexed { index, i ->
                sumCoefficients.add(i + other.coefficients[index])
            }
        } else {
            other.coefficients.forEachIndexed { index, i ->
                sumCoefficients.add(i + coefficients[index])
            }
        }
        return Polynomial(sumCoefficients)
    }
}

fun main() {
    val x = Polynomial(listOf(-1, -2, -3, -4))
    println(x.toString())
}
