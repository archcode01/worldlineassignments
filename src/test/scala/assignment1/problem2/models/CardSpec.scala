/**
  * Copyright (c) Metro Group
  */
package assignment1.problem2.models

import utils.UnitSpec

class CardSpec extends UnitSpec{
  "Card" should "create card object from string" in {
    val c = Card("5H")
    assert(c.kind == "H")
    assert(c.value == "5")
    assert(c.intValue == 5)
  }

  it should "create card object from string for higher card" in {
    val c = Card("TH")
    assert(c.kind == "H")
    assert(c.value == "T")
    assert(c.intValue == 10)
  }

  it should "create card object from string for ACE higher card" in {
    val c = Card("AC")
    assert(c.kind == "C")
    assert(c.value == "A")
    assert(c.intValue == 14)
  }

  it should "sort 2 cards based on int value of the card" in {
    val c1 = Card("5", "D")
    val c2 = Card("2", "H")
    assert(Card.sortFunc(c2,c1))
    assert(!Card.sortFunc(c1,c2))
  }
}
