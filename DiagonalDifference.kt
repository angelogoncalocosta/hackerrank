import java.lang.Math.abs

fun main(args: Array<String>) {
    val size = readLine()!!.toInt()
    val mat: MutableList<List<Int>> = arrayListOf()
    for (i in 0 until size) {
        mat.add(readLine()!!.split(" ").map { it.toInt() })
    }
    val firstdiag = (0 until size).sumBy { mat[it][it] }
    val seconddiag = (0 until size).sumBy { mat[it][(size - 1) - it] }
    println(abs(firstdiag - seconddiag))
}
