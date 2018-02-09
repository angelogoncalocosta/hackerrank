fun main(args: Array<String>) {
    val year = readLine()!!.toInt()
    if (year in 1700..2700) {
        if (year > 1918) {
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) println("12.09." + year)
            else println("13.09." + year)
        }
        if (year == 1918) println("26.09." + year)
        if (year < 1918) {
            if (year % 4 == 0) println("12.09." + year)
            else println("13.09." + year)
        }
    }
}
