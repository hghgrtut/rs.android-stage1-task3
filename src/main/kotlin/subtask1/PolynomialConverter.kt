package subtask1

import java.lang.StringBuilder
import kotlin.math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null
        var degr = numbers.lastIndex
        var polynomial = StringBuilder("${numbers[0]}${degree(degr)}")
        for (i in 1..numbers.lastIndex){
            degr--
            if (numbers[i]>0) { polynomial.append(
                    if (i==numbers.lastIndex || numbers[i]>1) " + ${numbers[i]}${degree(degr)}"
                    else " + ${degree(degr)}")
            } else if (numbers[i]<0) { polynomial.append(
                    if (i==numbers.lastIndex || numbers[i]<-1) " - ${abs(numbers[i])}${degree(degr)}"
                    else " - ${degree(degr)}")
            }
        }
        return polynomial.toString()
    }

    private fun degree(degr: Int): String{
         return when(degr){
             0 -> ""
             1 -> "x"
             else ->"x^$degr"
         }
    }
}
