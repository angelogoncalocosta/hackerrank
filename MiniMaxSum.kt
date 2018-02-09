fun main(args: Array<String>) {
    val inp = readLine()!!
    val sortlista = inp.split(" ").map { it.toLong() }.sorted()
    val maxi = sortlista.takeLast(4).sum()
    val mini = sortlista.take(4).sum()
    print("$mini $maxi")
}