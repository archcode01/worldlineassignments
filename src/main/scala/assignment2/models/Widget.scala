/**
  * Copyright (c) Metro Group
  */
package assignment2.models

trait Widget {
  def x: Position
  def y: Position
  def print: String
  def isValid:Boolean = x.isValid && y.isValid
}
