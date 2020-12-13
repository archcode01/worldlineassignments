/**
  * Copyright (c) Metro Group
  */
package assignment1.problem2.models

import scala.util.{Failure, Success, Try}
import Card._

object Card {
  val J:(String,Int) = ("J",11)
  val Q:(String,Int) = ("Q",12)
  val K:(String,Int) = ("K",13)
  val A:(String,Int) = ("A",14)
  val validHigherKindValues = Seq(J,Q,K,A)
  def getIntValueOfHigherCards(i:String): Int = validHigherKindValues.find(x=> {x._1 == i}).get._2

  def apply(tmp:String):Card = {
    Card(tmp.charAt(0).toString, tmp.charAt(1).toString)
  }

  def sortFunc(c1:Card, c2:Card): Boolean = {
    c1.intValue < c2.intValue
  }

}

case class Card (value:String, kind:String){
  val intValue = Try{value.toInt}match{
    case Success(a) => a
    case Failure(ex) => getIntValueOfHigherCards(value)
  }
}
