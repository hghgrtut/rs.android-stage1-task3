package subtask4

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decompose(number.toLong()*number.toLong(), number)?.toTypedArray()
    }

    private fun decompose(sum: Long, number: Int): ArrayList<Int>? {
            if (sum<0L) return null
            else if (sum==0L) return ArrayList()
            else {
                var n=number
                var arl: ArrayList<Int>? =null
                while (n>1 && arl == null){
                    n--
                    arl=decompose(sum-n.toLong()*n.toLong(), n)
                }
                arl?.add(n)
                return arl
            }
    }
}
