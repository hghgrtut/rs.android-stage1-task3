package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var n=numberOfItems
        val integerArray: ArrayList<Int> = ArrayList()
        var product=1
        for (item in itemsFromArray) if (item is Int) integerArray.add(item)
        if (integerArray.size==0) {product=0}
        else if (integerArray.size<=n) {integerArray.forEach { num -> product*=num }}
        else {
            integerArray.sort()
            while (n>1){
                if (integerArray[0]*integerArray[1]>integerArray[integerArray.lastIndex]*integerArray[integerArray.lastIndex-1]) {
                    product*=integerArray[0]*integerArray[1]
                    integerArray.removeAt(0)
                    integerArray.removeAt(1)
                } else{
                    product*=integerArray[integerArray.lastIndex]*integerArray[integerArray.lastIndex-1]
                    integerArray.removeAt(integerArray.lastIndex-1)
                    integerArray.removeAt(integerArray.lastIndex)
                }
                n-=2
            }
            if (n==1){product*= if (integerArray[0]>integerArray.last()) integerArray[0] else integerArray.last()}
        }
        return product
    }
}
