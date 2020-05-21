package subtask5

import java.lang.StringBuilder

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number[0]=='-') return null
        val list: ArrayList<String> = ArrayList()
        for(position in number.indices) list.addAll(changeNumber(position, number))
        return list.toTypedArray()
    }

    private fun changeNumber(position: Int, number: String): ArrayList<String>{
        val possibleDigits:Array<Char> = when (number[position]){
            '0' -> arrayOf('8')
            '1' -> arrayOf('2', '4')
            '2' -> arrayOf('1', '3', '5')
            '3' -> arrayOf('2', '6')
            '4' -> arrayOf('1', '5', '7')
            '5' -> arrayOf('2', '4', '6', '8')
            '6' -> arrayOf('3', '5', '9')
            '7' -> arrayOf('4', '8')
            '8' -> arrayOf('5', '7', '9', '0')
            else -> arrayOf('6', '8')
        }
        return newNumbers(position, possibleDigits, number)
    }

    private fun newNumbers(position: Int, digits: Array<Char>, number: String): ArrayList<String>{
        val strbuf = StringBuilder(number)
        val numbers: ArrayList<String> = ArrayList()
        for (i in digits.indices){
            strbuf[position]=digits[i]
            numbers.add(strbuf.toString())}
        return numbers
    }
}
