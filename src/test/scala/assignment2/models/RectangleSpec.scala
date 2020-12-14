/**
  * Copyright (c) Metro Group
  */
package assignment2.models

import utils.UnitSpec

class RectangleSpec extends UnitSpec {
  "Rectangle" should "print bom line specific to rectangle" in {
    val expected = "Rectangle (10,10) width=30 height=40"
    val c = Rectangle(Position(10), Position(10), 30,40)
    assert(c.print == expected)
  }

  it should "return false for isValid when position is negative" in {
    val c = Rectangle(Position(-10), Position(10), 30,40)
    assert(!c.isValid)
  }

}
