import datastructures.BinaryTree

fun main(args: Array<String>) {

    val list = listOf(5, 3, 10, 33, 1, 0, 353, 63, 11, 30, 6)
    val tree = BinaryTree.build(list) ?: return
    println(tree)
    println(tree.search(6))
}