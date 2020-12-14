/**
  * Copyright (c) Metro Group
  */
package assignment2.models

case class Square ( override val x: Position, override val y: Position, width: Integer) extends Widget{
  override def print: String = {
    s"Square (${x.pos},${y.pos}) size=${width}"
  }
//  override def isValid: Boolean = {
//    x.isValid && y.isValid && (width <= x.pos && width <=y.pos)
//  }
}