/**
  * Copyright (c) Metro Group
  */
package assignment1.problem2.models

import utils.UnitSpec

class GameSpec extends UnitSpec{
  "Game" should "determin player 1 is winner" in {

    val str1 = "5D 8C 9S JS AC 2C 5C 7D 8S QH"
    val g = Game(str1)
    assert(g.isPlayer1Winner)
  }

  it should "determine player 1 is not winner" in {
    val str2 = "5H 5C 6S 7S KD 2C 3S 8S 8D TD"
    val g = Game(str2)
    assert(!g.isPlayer1Winner)
  }
}
