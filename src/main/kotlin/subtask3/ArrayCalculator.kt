package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var n=numberOfItems
        val integerArray: ArrayList<Int> = ArrayList()
        var product=1
        for (item in itemsFromArray) if (item is Int) integerArray.add(item)
        if (integerArray.size==0) {product=0}
        else if (integerArray.size<=n) {product=integerArray.reduce(Int::times)}
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
            if (n==1){
                if (integerArray.last()>=0) product*= if (integerArray[0]>integerArray.last()) integerArray[0] else integerArray.last()
                else{
                    product=1
                    integerArray.removeAll(integerArray)
                    val positive: ArrayList<Int> = ArrayList()
                    val negative = integerArray
                    for (item in itemsFromArray) if (item is Int){
                        if (item>=0) positive.add(item)
                        else negative.add(item)
                    }
                    n=numberOfItems
                    while (n>1) {
                        positive.sort()
                        negative.sortDescending()
                        if (positive.lastIndex>0 && positive[0] * positive[1] < negative[0] * negative[1]) {
                            product *= positive[0] * positive[1]
                            positive.removeAt(0)
                            positive.removeAt(1)
                        } else {
                            product *= negative[0] * negative[1]
                            negative.removeAt(0)
                            negative.removeAt(1)
                        }
                        n -= 2
                    }
                    if (n==1) product *= negative[0]
                }
            }
        }
        return product
    }
}
