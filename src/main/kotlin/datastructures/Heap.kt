package datastructures

class Heap {

    private val elements: Array<Int?> = Array(20) { null }
    private var size: Int = 0

    fun insert(num: Int) {
        elements[++size] = num
        heapifyUp(size)
    }

    fun extractMinimum(): Int? {
        val top = elements[1]
        elements[1] = elements[size]
        elements[size--] = null
        heapifyDown(1)
        return top
    }

    fun isEmpty(): Boolean = size == 0

    private fun heapifyUp(pos: Int) {
        if (pos > 1) {
            val parentPos = pos / 2
            // Swap places if the child is smaller than the parent.
            if (elements[pos]!! < elements[parentPos]!!) {
                elements[pos] = elements[parentPos].also { elements[parentPos] = elements[pos] }
                heapifyUp(parentPos)
            }
        }
    }

    private fun heapifyDown(pos: Int) {
        var minChildPos: Int = -1
        val leftChildPos = 2 * pos
        val rightChildPos = 2 * pos + 1
        when {
        // There is no left child.
            leftChildPos > size -> return
        // There is a left child, check if right child is smaller.
            leftChildPos < size ->
                minChildPos = if (elements[leftChildPos]!! < elements[rightChildPos]!!) leftChildPos else rightChildPos
        // There is no right child.
            leftChildPos == size -> minChildPos = leftChildPos
        }

        // Swap places if the child is smaller than the parent.
        if (elements[minChildPos]!! < elements[pos]!!) {
            elements[pos] = elements[minChildPos].also { elements[minChildPos] = elements[pos] }
            heapifyDown(minChildPos)
        }
    }

    override fun toString(): String = "[${elements.joinToString(",")}]"
}