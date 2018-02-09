
import java.text.SimpleDateFormat

fun main(args: Array<String>) {
    val time = readLine()!!
    val displayFormat = SimpleDateFormat("HH:mm:ss")
    val parseFormat = SimpleDateFormat("hh:mm:ssa")
    println(displayFormat.format(parseFormat.parse(time)))
}
