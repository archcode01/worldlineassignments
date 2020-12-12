/**
  * Copyright (c) Metro Group
  */
package problem1

import java.time.{DayOfWeek, LocalDate}

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
