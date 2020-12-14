/**
  * Copyright (c) Metro Group
  */
package assignment1.problem2

import assignment1.problem2.models.Game

import scala.io.Source

object Main extends App {

//  val str2 = "5H 5C 6S 7S KD 2C 3S 8S 8D TD"
//  val str1 = "5D 8C 9S JS AC 2C 5C 7D 8S QH"
//
//  val g = Game(str1)
////  println(g.isPlayer1Winner)
  println(s"Payer1 wins ${Source.fromResource("poker.txt").getLines.toSeq.map(Game.apply).count(_.isPlayer1Winner)} times")

}
