package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val f: Long = fact(array[1])
        var k=0
        var c=0L
        while (c<array[0] && k<=array[1]){
            k++
            c=f/fact(k)/fact(array[1]-k)
        }
        return if (c>=array[0]) k else null
    }

    private fun fact(n: Int): Long{
        var proizv=1L
        for (i in n downTo 2){
            proizv*=i
        }
        return proizv
    }
}
