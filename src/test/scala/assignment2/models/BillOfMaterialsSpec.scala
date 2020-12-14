/**
  * Copyright (c) Metro Group
  */
package assignment2.models

import utils.UnitSpec

class BillOfMaterialsSpec extends UnitSpec {
  "Textbox" should "print bom line specific to Textbox" in {
    val expected = """----------------------------------------------------------------
                     |Bill of Materials
                     |----------------------------------------------------------------
                     |Rectangle (10,10) width=30 height=40
                     |Square (15,30) size=35
                     |Ellipse (100,150) diameterH = 300, diameterV = 200
                     |Circle (1,1) size=300
                     |Textbox (5,5) width=200 height=100 text="sample text"
                     |----------------------------------------------------------------
                     |""".stripMargin
    val rect = assignment2.models.Rectangle(Position(10), Position(10), 30, 40)
    val square = Square(Position(15), Position(30),35)
    val ellipse = Ellipse(Position(100), Position(150),300, 200)
    val circle = Circle(Position(1), Position(1), 300)
    val tbox = TextBox(Position(5), Position(5), 200,100, Some("sample text"))

    val bom = BillOfMaterials(Seq(rect, square, ellipse, circle, tbox))

    assert(bom.print == expected)
  }

  it should "print abort message when any of the widget has negative position" in {
    val expected = "+++++Abort+++++"
    val rect = assignment2.models.Rectangle(Position(10), Position(10), 30, 40)
    val square = Square(Position(-15), Position(30),35)
    val ellipse = Ellipse(Position(100), Position(150),300, 200)
    val circle = Circle(Position(1), Position(1), 300)
    val tbox = TextBox(Position(5), Position(5), 200,100, Some("sample text"))

    val bom = BillOfMaterials(Seq(rect, square, ellipse, circle, tbox))

    assert(bom.print == expected)
  }

}
