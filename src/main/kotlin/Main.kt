import datastructures.Heap

fun main(args: Array<String>) {

    val heap = Heap()

    heap.insert(5)
    heap.insert(2)
    heap.insert(10)
    heap.insert(1)
    heap.insert(22)
    heap.insert(3)
    heap.insert(9)
    heap.insert(0)

    println(heap)

    while (!heap.isEmpty()) {
        val min = heap.extractMinimum()
        println("Extracted $min")
        println(heap)
    }

}