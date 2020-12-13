/**
  * Copyright (c) Metro Group
  */
package assignment2.models

case class Position(pos: Integer){
//  require(pos > 0, "position should be positive integer")
  lazy val isValid:Boolean = pos > 0
}
