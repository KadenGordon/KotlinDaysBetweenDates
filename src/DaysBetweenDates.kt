fun main(args: Array<String>) {
    val startDay: Date
    val targetDay: Date
    if(args.size == 6) {
        startDay = Date(args[0].toInt(), args[1].toInt(), args[2].toInt())
        targetDay = Date(args[3].toInt(), args[4].toInt(), args[5].toInt())
    } else {
        print("Day of first date: ")
        val firstDay = readLine()!!.toInt()
        print("Month of first date: ")
        val firstMonth = readLine()!!.toInt()
        print("Year of first date: ")
        val firstYear = readLine()!!.toInt()
        print("Day of second date: ")
        val secondDay = readLine()!!.toInt()
        print("Month of second date: ")
        val secondMonth = readLine()!!.toInt()
        print("Year of second date: ")
        val secondYear = readLine()!!.toInt()
        startDay = Date(firstDay, firstMonth, firstYear)
        targetDay = Date(secondDay, secondMonth, secondYear)
    }
    var currentDay = startDay
    var i = 0
    while(!currentDay.equals(targetDay)) {
        println(currentDay)
        try {
            Thread.sleep(17L)
        } finally {}
        currentDay++
        i++
    }
    println("There were $i days between $startDay and $targetDay")
}

data class Date(var day: Int, var month: Int, var year: Int) {
    operator fun inc(): Date {
        return if(this.day < daysInMonth(this)) {
            Date(this.day+1, this.month, this.year)
        } else {
            if(this.month==12) {
                Date(1, 1, this.year + 1)
            } else {
                Date(1, this.month+1, this.year)
            }
        }
    }
    fun equals(other: Date): Boolean = this.day == other.day && this.month == other.month && this.year == other.year
    private fun daysInMonth(day: Date): Int {
        return if(day.month == 2) {
            if(isLeapYear(day)) 29
            else 28
        } else if(day.month == 1 || day.month == 3 || day.month == 5 || day.month == 7 || day.month == 8 || day.month == 10 || day.month == 12) 31
        else 30
    }
    private fun isLeapYear(day: Date): Boolean {
        return if(day.year % 100 == 0) (day.year % 400 == 0)
        else (day.year % 4 == 0)
    }
    override fun toString(): String = "$month/$day/$year"
}
