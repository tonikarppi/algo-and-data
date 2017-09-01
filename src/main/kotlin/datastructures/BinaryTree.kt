package datastructures

class BinaryTree<T : Comparable<T>>(
        val data: T,
        private val left: BinaryTree<T>?,
        private val right: BinaryTree<T>?
) {

    fun insert(newElement: T): BinaryTree<T> =
            if (newElement < data) {
                val newLeft = left?.insert(newElement) ?: BinaryTree(newElement, null, null)
                BinaryTree(data, newLeft, right)
            } else {
                val newRight = right?.insert(newElement) ?: BinaryTree(newElement, null, null)
                BinaryTree(data, left, newRight)
            }

    fun search(soughtElement: T): Boolean =
            when {
                soughtElement < data -> left?.search(soughtElement) ?: false
                soughtElement > data -> right?.search(soughtElement) ?: false
                else -> true
            }

    override fun toString(): String = "{$data, left: ${left.toString()}, right: ${right.toString()}}"

    companion object {
        fun <T : Comparable<T>> build(list: List<T>): BinaryTree<T>? {
            if (list.isEmpty()) return null
            val root = BinaryTree(list.first(), null, null)
            val rest = list.subList(1, list.size)
            var tree = root
            for (r in rest) {
                tree = tree.insert(r)
            }
            return tree
        }
    }
}