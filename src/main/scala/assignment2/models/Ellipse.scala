/**
  * Copyright (c) Metro Group
  */
package assignment2.models

case class Ellipse ( override val x: Position, override val y: Position, hDia:Integer, vDia:Integer) extends Widget{
  override def print: String = {
    s"Ellipse (${x.pos},${y.pos}) diameterH = ${hDia}, diameterV = $vDia"
  }

}