import java.awt.CardLayout
import kotlin.math.roundToInt

fun main() {
    val typeOfCard: String = "VK Pay" // По умолчанию
    val thisTransaction: Int
    val countInDay: Int
    val countInMonth: Int
    println(commission(thisTransaction = 14_000))
}

fun checkLimit(typeOfCard: String, countInDay: Int, countInMonth: Int ): Boolean{
    val limitInDay = 150_000
    val limitInMonth = 600_000
    val limitVKDay = 15_000
    val limitVKMonth = 40_000
    var check: Boolean = false
    if(typeOfCard == "VK pay"){
        if ((countInDay > limitVKMonth) || (countInDay > limitVKDay))  check = true
    } else {
        if ((countInDay > limitInDay) || (countInMonth > limitInMonth)) check = true
    }
    return check
}

fun commissionOutLimitMM(thisTransaction: Int): Int{ //функция расчета комиссии для MasterCard & Maestro
    return   (thisTransaction * 0.006).roundToInt() + 20  // 0,6% + 20 рублей
}

fun commissionOutLimitVM(thisTransaction: Int): Int{ //функция расчета комиссии для Visa & Mир
    return (thisTransaction * 0.0075).roundToInt() + 35 // 0,75% + 35рублей
}

fun commission(
    typeOfCard: String = "VK pay",
    thisTransaction: Int,
    countInDay: Int = 0,
    countInMonth: Int = 0
    ):Int {
    val result: Int
    return  when (typeOfCard){
        "MasterCard" ->   if (checkLimit(typeOfCard,countInDay, countInMonth)) {commissionOutLimitMM(thisTransaction)} else thisTransaction
        "Maestro" ->  if (checkLimit(typeOfCard,countInDay, countInMonth)) {commissionOutLimitMM(thisTransaction)} else thisTransaction
        "Visa" ->   if (checkLimit(typeOfCard,countInDay, countInMonth)){commissionOutLimitVM(thisTransaction)} else thisTransaction
        "Мир" -> if (checkLimit(typeOfCard,countInDay, countInMonth)){commissionOutLimitVM(thisTransaction)} else thisTransaction
        "VK pay" -> thisTransaction
        else -> 0
    }


}



