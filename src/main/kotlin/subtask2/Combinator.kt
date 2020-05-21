package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val f: Long = fact(array[1].toLong())
        var k=0
        var c=0L
        var f1=1
        while (c<array[0] && k<=array[1]){
            k++
            f1*=k
            c=f/f1/fact((array[1]-k).toLong())
        }
        return if (c>=array[0]) k else null
    }

    private fun fact(n: Long): Long {return if (n>0) (1L..n).reduce(Long::times) else 1}
}
