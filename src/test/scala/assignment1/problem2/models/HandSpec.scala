/**
  * Copyright (c) Metro Group
  */
package assignment1.problem2.models

import utils.UnitSpec

class HandSpec extends UnitSpec{
  "Hand" should "determine for one pair" in {
    val str2 = "5H 5C 6S 7S KD"
    val cards = str2.split(" ").map(Card.apply)
    val h= Hand(cards)

    assert(h.highestInHand == 13)
    assert(h.hasOnePair)
    assert(!h.hasRoyalFlush)

  }

  it should "determine for royal flush" in {
    val str2 = "TH JH QH KH AH"
    val cards = str2.split(" ").map(Card.apply)
    val h= Hand(cards)

    assert(h.highestInHand == 14)
    assert(h.hasRoyalFlush)

  }


  it should "determine for straignt flush" in {
    val str2 = "2H 3H 4H 5H 6H"
    val cards = str2.split(" ").map(Card.apply)
    val h= Hand(cards)

    assert(h.highestInHand == 6)
    assert(h.hasStraightFlush)
    assert(!h.hasRoyalFlush)

  }

  it should "determine for four of a kind" in {
    val str2 = "2H 2D 2C 2S 6H"
    val cards = str2.split(" ").map(Card.apply)
    val h= Hand(cards)

    assert(h.highestInHand == 6)
    assert(h.hasFourOfAKind)
    assert(!h.hasRoyalFlush)

  }

  it should "determine for full house" in {
    val str2 = "2H 2D 2C 6S 6H"
    val cards = str2.split(" ").map(Card.apply)
    val h= Hand(cards)

    assert(h.highestInHand == 6)
    assert(h.hasFullHouse)
    assert(!h.hasRoyalFlush)

  }

  it should "determine for three of a kind" in {
    val str2 = "2H 2D 2C 3S 6H"
    val cards = str2.split(" ").map(Card.apply)
    val h= Hand(cards)

    assert(h.highestInHand == 6)
    assert(h.hasThreeOfAKind)
    assert(!h.hasRoyalFlush)

  }

  it should "determine for two pairs" in {
    val str2 = "2H 2D 3C 3S 6H"
    val cards = str2.split(" ").map(Card.apply)
    val h= Hand(cards)

    assert(h.highestInHand == 6)
    assert(h.hasTwoPairs)
    assert(!h.hasRoyalFlush)

  }


  it should "determine for no rank" in {
    val str2 = "AH 2D 3C 9S 6H"
    val cards = str2.split(" ").map(Card.apply)
    val h= Hand(cards)

    assert(h.highestInHand == 14)
    assert(h.rank == Hand.Rank.NoValue)
    assert(!h.hasRoyalFlush)

  }
}
