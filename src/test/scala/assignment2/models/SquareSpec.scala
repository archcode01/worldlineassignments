/**
  * Copyright (c) Metro Group
  */
package assignment2.models

import utils.UnitSpec

class SquareSpec extends UnitSpec {
  "Square" should "print bom line specific to square" in {
    val expected = "Square (15,30) size=35"
    val c = Square(Position(15), Position(30), 35)
    assert(c.print == expected)
  }

  it should "return false for isValid when position is negative" in {
    val c = Square(Position(-10), Position(10), 35)
    assert(!c.isValid)
  }

}
