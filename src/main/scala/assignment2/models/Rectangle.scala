/**
  * Copyright (c) Metro Group
  */
package assignment2.models

case class Rectangle  ( override val x: Position, override val y: Position, width: Integer, height: Integer) extends Widget{
  override def print: String = {
    s"Rectangle (${x.pos},${y.pos}) width=${width} height=${height}"
  }

}
