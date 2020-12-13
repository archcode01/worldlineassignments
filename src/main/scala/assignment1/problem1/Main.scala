/**
  * Copyright (c) Metro Group
  */
package assignment1.problem1

import java.time.{DayOfWeek, LocalDate}

/***
  * You are given the following information, but you may prefer to do some research for yourself.
  * • 1 Jan 1900 was Monday.
  * • September, April, June and November had 30 days. All the rest of the months have 31 days.
  * • Saving February alone, which has 28, rain or shine. And on leap years, twenty-nine.
  * • A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
  * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
  */

object Main extends App{

  val beginDate = LocalDate.of(1901,1,1)
  val endDate = LocalDate.of(2001,1,1)
  var tempDate = beginDate
  var counter = 0
  while(tempDate.isBefore(endDate)){

    val cnt = if(isApplicable(tempDate)) 1 else 0
    counter = counter + cnt
    tempDate = tempDate.plusDays(1)
  }

  println(s"number of sundays that fall on first of month - $counter")



  private def isApplicable(dt:LocalDate):Boolean ={
    if(dt.getDayOfMonth == 1 && dt.getDayOfWeek == DayOfWeek.SUNDAY){
      true
    }else{
      false
    }
  }



}
