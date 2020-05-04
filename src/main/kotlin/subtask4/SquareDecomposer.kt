package subtask4

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val ish=decompose(number*number, number)
        if (ish==null) return null
        else {
            val a: Array<Int>? = Array(ish.size-1){0}
            for (i in a!!.indices) a[i]=ish[i+1]
            return a
        }
    }

    private fun decompose(sum: Int, number: Int): ArrayList<Int>? {
            if (sum<0) return null
            else if (sum==0) return arrayListOf(number)
            else {
                var n=number-1
                var arl: ArrayList<Int>? =null
                while (n>0 && arl ==null){
                    arl=decompose(sum-n*n, n)
                    n--
                }
                if (arl == null) return null
                else{
                    arl.add(n+1)
                    return arl
                }
            }
    }
}
