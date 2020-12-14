/**
  * Copyright (c) Metro Group
  */
package assignment2.models

import utils.UnitSpec

class EllipseSpec extends UnitSpec {
  "Ellipse" should "print bom line specific to ellipse" in {
    val expected = "Ellipse (100,150) diameterH = 300, diameterV = 200"
    val c = Ellipse(Position(100), Position(150), 300,200)
    assert(c.print == expected)
  }

  it should "return false for isValid when position is negative" in {
    val c = Ellipse(Position(-100), Position(150), 300,200)
    assert(!c.isValid)
  }


}
