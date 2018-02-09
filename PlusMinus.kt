fun main(args: Array<String>) {
    val size = readLine()!!.toDouble()
    val numbers = readLine()!!
    val listofsize = numbers.split(" ").map { it.toDouble() }
    val positivefraction: Double = listofsize.filter { it > 0.0 }.count() / size
    val negativefraction: Double = listofsize.filter { it < 0.0 }.count() / size
    val neutralfraction: Double = listofsize.filter { it == 0.0 }.count() / size
    println(positivefraction)
    println(negativefraction)
    println(neutralfraction)
}