/**
  * Copyright (c) Metro Group
  */
package assignment2.models

import utils.UnitSpec

class TextBoxSpec extends UnitSpec {
  "Textbox" should "print bom line specific to Textbox" in {
    val expected = "Textbox (5,5) width=200 height=100 text=\"sample text\""
    val c = TextBox(Position(5), Position(5), 200, 100, Some("sample text"))
    assert(c.print == expected)
  }

  it should "print bom line specific to Textbox when no text is present" in {
    val expected = "Textbox (5,5) width=200 height=100 text=\"\""
    val c = TextBox(Position(5), Position(5), 200, 100, None)
    assert(c.print == expected)
  }

  it should "return false for isValid when position is negative" in {
    val c = TextBox(Position(-5), Position(5), 200, 100, Some("sample text"))
    assert(!c.isValid)
  }

}
