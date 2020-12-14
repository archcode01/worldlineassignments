/**
  * Copyright (c) Metro Group
  */
package assignment1.problem2.models
import Hand.{findPairs, _}
import Hand.Rank._


object Hand{

  object Rank{
    val NoValue = 0
    val HighCard = 1
    val OnePair = 2
    val TwoPairs = 3
    val ThreeOfAKind = 4
    val Straight = 5
    val Flush = 6
    val FullHouse = 7
    val FourOfKind = 8
    val StraightFlush = 9
    val RoyalFlush = 10
  }

  def findPairs(cards:Seq[Card]): Seq[(Card, Card)] = {
    cards.zip(cards.tail).collect({
      case (x,y) if x.intValue == y.intValue => (x,y)
    })
  }
//
//  def highestValueInSameRank(rank:Int, cards:Seq[Card]) = {
//    rank match {
//      case RoyalFlush => 0
//      case StraightFlush =>
//      case FourOfKind =>
//      case FullHouse =>
//      case Flush =>
//      case Straight =>
//      case ThreeOfAKind =>
//      case TwoPairs =>
//      case OnePair =>
//      case NoValue =>
//
//    }
//  }

}


case class Hand (cards:Seq[Card]){
  require(cards.size == 5)

  val sortedCards: Seq[Card] = cards.sortWith(Card.sortFunc)

  lazy val rank: Int = if(hasRoyalFlush) {
    RoyalFlush
  }else if(hasStraightFlush){
    StraightFlush
  }else if(hasFourOfAKind){
    FourOfKind
  }else if(hasFullHouse){
    FullHouse
  }else if(hasFlush){
    Flush
  }else if(hasStraight){
    Straight
  }else if (hasThreeOfAKind){
    ThreeOfAKind
  }else if(hasTwoPairs){
    TwoPairs
  }else if(hasOnePair){
    OnePair
  }else{
    NoValue
  }

  lazy val hasRoyalFlush: Boolean = {
    if(sortedCards.head.intValue == 10 && hasStraightFlush){
      true
    }else{
      false
    }

  }


  lazy val hasStraightFlush: Boolean = {
    if(hasFlush && hasStraight){
      true
    }else{
      false
    }

  }

  lazy val hasFourOfAKind: Boolean = {
    val a = findPairs(sortedCards)
    if(a.size == 3 &&
      (a.head._1.intValue == a(1)._1.intValue && a
      (1)._1.intValue == a(2)._1.intValue)){
      true
    }else{
      false
    }
  }


  lazy val hasFullHouse:Boolean = {
    val a = findPairs(sortedCards)
    if(a.size ==3 &&
      ((a.head._1.intValue == a(1)._1.intValue && a(1)._1.intValue != a(2)._1.intValue) ||
        (a.head._1.intValue != a(1)._1.intValue && a(1)._1.intValue == a(2)._1.intValue) )
    ){
      true
    }else{
      false
    }
  }

  lazy val hasFlush: Boolean = {
    sortedCards.zip(sortedCards.tail).forall(p => {p._1.kind == p._2.kind})
  }

  lazy val hasStraight: Boolean = {
    sortedCards.zip(sortedCards.tail).forall(p => {p._1.intValue + 1 == p._2.intValue})
  }

  lazy val highestInHand: Int = {
    sortedCards.last.intValue
  }

  lazy val hasOnePair: Boolean = {
    //    cards.zip(cards.tail).exists(p => {p._1.intValue  == p._2.intValue})
    val a = findPairs(sortedCards)
    if(a.size == 1) true else false
  }

  lazy val highestOfOnePair: Int = {
    val a = findPairs(sortedCards)
    if(a.size == 1){
      a.head._1.intValue
    }  else {
      0
    }
  }

  lazy val hasTwoPairs: Boolean = {
    //    cards.zip(cards.tail).exists(p => {p._1.intValue  == p._2.intValue})
    val a = findPairs(sortedCards)
    if(a.size == 2 && a.head._1.intValue != a(1)._1.intValue) true else false
  }

  lazy val highestOfTwoPairs: Int = {
    val a = findPairs(sortedCards)
    if(a.size == 2 && a.head._1.intValue != a(1)._1.intValue) {
      a(1)._1.intValue
    } else{
      0
    }
  }

  lazy val hasThreeOfAKind: Boolean = {
    //    cards.zip(cards.tail).exists(p => {p._1.intValue  == p._2.intValue})
    val a = findPairs(sortedCards)
    if(a.size == 2 && a.head._1.intValue == a(1)._1.intValue) true else false
  }

  lazy val highestOfThreeOfAKind: Int = {
    val a = findPairs(sortedCards)
    if(a.size == 2 && a.head._1.intValue == a(1)._1.intValue) a.head._1.intValue else 0

  }


  lazy val highestValueInRank: Int = {
    rank match {
      case RoyalFlush => 0
      case StraightFlush => this.highestInHand
      case FourOfKind => this.highestInHand
      case FullHouse => this.highestInHand
      case Flush => this.highestInHand
      case Straight => this.highestInHand
      case ThreeOfAKind => this.highestOfThreeOfAKind
      case TwoPairs => this.highestOfTwoPairs
      case OnePair => this.highestOfOnePair
      case NoValue => this.highestInHand

    }
  }


}

