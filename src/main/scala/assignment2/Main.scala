/**
  * Copyright (c) Metro Group
  */
package assignment2

import assignment2.models.{BillOfMaterials, Circle, Ellipse, Position, Square, TextBox}

object Main extends App{

  val rect = assignment2.models.Rectangle(Position(10), Position(10), 30, 40)
  val square = Square(Position(15), Position(30),35)
  val ellipse = Ellipse(Position(100), Position(150),300, 200)
  val circle = Circle(Position(1), Position(1), 300)
  val tbox = TextBox(Position(5), Position(5), 200,100, Some("sample text"))

  val bom = BillOfMaterials(Seq(rect, square, ellipse, circle, tbox))

  println(bom.print)

}
