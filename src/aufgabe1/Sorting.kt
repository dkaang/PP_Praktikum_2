package aufgabe1

class Sorting {
    fun <A> sort(list: List<A>, ordering: Ordering<A>): List<A> {
        if (list.isEmpty()) return emptyList()
        val copiedList = list.toMutableList()
        var sorted = false
        var tmp: A?
        while (!sorted) {
            sorted = true
            for (i in 0 until copiedList.lastIndex) {
                val left = copiedList[i]
                val right = copiedList[i + 1]
                val result = ordering(left, right)
                if (result == OrderResult.Higher) {
                    tmp = left
                    copiedList[i] = right
                    copiedList[i + 1] = tmp
                    sorted = false
                }
            }
        }
        return copiedList
    }
}