fun main(){
    val timeOfLastSeen : Int = 4500 //время последнего посещения(в секундах)
    val hoursInDay = 24
    val minutesInHour = 60
    val secondsInMinutes = 60
    val stringInitial = "Был(-а) в сети "
    var stringFinal: String


    fun timeInMinutes(time: Int): String {
        return when {
            time in 5..20 -> "$time минут назад"
            time % 10 == 1 -> "$time минуту назад"
            (time % 10) in 2..4 -> "$time минуты назад"
            else -> "$time минут назад"
        }
    }
    fun timeInHours(time: Int):String{
        return when {
            time in 5..20 -> "$time часов назад"
            time == 1 || time == 21 -> "$time час назад"
            time in 2..4 || time == 22 || time == 23 -> "$time часа назад"
            else -> ""
        }
    }
    fun timeInDays(time:Int): String {
        return  when {
            time == 1 -> "вчера"
            time == 2 -> "позавчера"
            else -> "давно"
        }

    }

    if (timeOfLastSeen in 1..secondsInMinutes){
        println(stringInitial + "только что")
    }else if (timeOfLastSeen/secondsInMinutes < minutesInHour){
        val time = timeOfLastSeen/secondsInMinutes
        println(stringInitial+ timeInMinutes(time))
    }else{
        val time = timeOfLastSeen / (secondsInMinutes * minutesInHour)
        println(stringInitial+ timeInDays(time))
    }






}