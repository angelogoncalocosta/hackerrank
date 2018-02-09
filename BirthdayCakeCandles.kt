fun main(args: Array<String>) {
    val candles = readLine()!!
    val listofsize = readLine()!!.split(" ").map { it.toLong() }.sorted()
    val maxsize = listofsize.max()
    val countmax = listofsize.count { it == maxsize }
    print("$countmax")
}