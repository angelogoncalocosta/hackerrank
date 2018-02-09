fun main(args: Array<String>) {
    val alice = readLine()!!.split(" ").map { it.toInt() }
    val bob = readLine()!!.split(" ").map { it.toInt() }
    var alicepoints = 0
    var bobpoints = 0
    for (i in 0..2) {
        if (alice[i] > bob[i]) {
            alicepoints++
        }
        if (alice[i] < bob[i]) {
            bobpoints++
        }
    }
    println("$alicepoints $bobpoints")
}