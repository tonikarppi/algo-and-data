import datastructures.LList

fun main(args: Array<String>) {

    val list = LList<Int>()

    list.insertAtStart(1)
    list.insertAtStart(2)
    list.insertAtStart(3)
    list.insertAtStart(4)

    println(list)

    println(list.search(1))
}