/**
I started with finding all unique characters -> distinctList

Then I created all possible combinations of pairs -> the two "for"
    I deleted other characters except the pair -> through regex -> anything that is not [ab]
    I filtered the pairs that contains alternating characters -> isAlternating
    I count the length of the string -> max
    The result is the maximum of string lengths.
 */
fun main(args: Array<String>) {
    val len = readLine()!!
    val s = readLine()!!

    val distinctList = s.toList().distinct().sorted()

    var max = 0
    for (i in 0 until distinctList.size - 1) {
        (i + 1 until distinctList.size)
                .asSequence()
                .map { s.replace(("[^${distinctList[i]}${distinctList[it]}]").toRegex(), "") }
                .filter { isAlternating(it) }
                .forEach { max = if (it.length > max) it.length else max }
    }
    println(max)
}

/**
 * Goes through string verifying if a != a+1
 */
private fun isAlternating(s: String) = (0 until s.length - 1).none { s[it] == s[it + 1] }

