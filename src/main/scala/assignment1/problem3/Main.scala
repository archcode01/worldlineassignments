/**
  * Copyright (c) Metro Group
  */
package assignment1.problem3

import scala.io.Source

/***
  * Problem 3:
  * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total
  * from top to bottom is 23.
  * • 3
  * • 7 4
  * • 2 4 6
  * • 8 5 9 3
  * That is, 3 + 7 + 4 + 9 = 23.
  */

object Main extends App {

  //val triangle = Seq(Seq(3),Seq(7,4),Seq(2,4,6),Seq(8,5,9,3))

  val triangle: Seq[Seq[Int]] = Source.fromResource("triangle.txt").getLines.toSeq.map(line => line.split(" ").toSeq.map(_.toInt))

  def reduceRows(upperRow:Seq[Int], lowerRow:Seq[Int]):Seq[Int] = {
    for(i <- upperRow.indices) yield {upperRow(i)+ Math.max(lowerRow(i), lowerRow(i+1))}
  }

  val result: Seq[Int] = triangle.reduceRight(reduceRows)

  println(result)


}
