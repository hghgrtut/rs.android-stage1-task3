package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        var result ="["
        if (count%2==1) for (tree in newstr("[0", count-1, 0)) result+=tree
        result+="]"
        return result
    }

    private fun newstr(nach: String, symb: Int, free: Int): ArrayList<String>{
        if (symb==0) return arrayListOf("$nach]")
        else {
            val arr = newstr("$nach,0,0", symb - 2, free+1)
            if (free>0) arr.addAll(newstr("$nach,null,null", symb, free-1))
            return arr
        }
    }
}