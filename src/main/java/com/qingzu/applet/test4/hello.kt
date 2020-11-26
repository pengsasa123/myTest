package com.qingzu.applet.test4

import java.time.LocalDate
import java.time.format.DateTimeFormatter

private fun updateLastDate(){
    val i = LocalDate.now().minusDays(1)
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val string = i.format(formatter)
}

fun main(){
    updateLastDate()
}