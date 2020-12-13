/**
  * Copyright (c) Metro Group
  */
package assignment2.models

case class TextBox  ( override val x: Position,
                 override val y: Position,
                 width: Integer,
                 height: Integer,
                 text:Option[String]) extends Widget{
  override def print: String = {
    s"Textbox (${x.pos},${y.pos}) width=${width} height=$height text=${"""""""+text.getOrElse("")+"""""""}"
  }

}