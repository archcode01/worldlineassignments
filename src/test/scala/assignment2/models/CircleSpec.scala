/**
  * Copyright (c) Metro Group
  */
package assignment2.models

import utils.UnitSpec

class CircleSpec extends UnitSpec {
  "Circle" should "print bom line specific to circle" in {
    val expected = "Circle (1,1) size=10"
    val c = Circle(Position(1), Position(1), 10)
    assert(c.print == expected)
  }

  it should "return false for isValid when position is negative" in {
    val c = Circle(Position(-1), Position(1), 10)
    assert(!c.isValid)
  }

}
