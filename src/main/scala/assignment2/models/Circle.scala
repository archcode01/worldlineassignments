/**
  * Copyright (c) Metro Group
  */
package assignment2.models

case class Circle( override val x: Position, override val y: Position, dia:Integer) extends Widget{
  override def print: String = {
    s"Circle (${x.pos},${y.pos}) size=${dia}"
  }

//  override def isValid: Boolean = {
//    x.isValid && y.isValid && (dia <= x.pos && dia <=y.pos)
//  }
}
