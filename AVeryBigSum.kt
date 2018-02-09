fun main(args: Array<String>) {
    val size = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toLong() }.sum()
    println("$arr")
}