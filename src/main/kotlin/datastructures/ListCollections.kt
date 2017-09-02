package datastructures

data class Node<T>(val data: T, var next: Node<T>?)

class LList<T> {

    private var first: Node<T>? = null

    fun insertAtStart(newElement: T) {
        first = when (first) {
            null -> Node(newElement, null)
            else -> Node(newElement, first)
        }
    }

    fun search(element: T): Boolean {
        var current = first
        while (current != null) {
            if (element == current.data) {
                return true
            }
            current = current.next
        }
        return false
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var current = first
        while (current != null) {
            sb.append(current.data)
            current = current.next
        }
        return "[${sb.toList().joinToString(", ")}]"
    }
}