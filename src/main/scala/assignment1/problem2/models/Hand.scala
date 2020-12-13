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

  def highestValueInSameRank(rank:Int, cards:Seq[Card]) = {
    rank match {
      case RoyalFlush => 0
      case StraightFlush =>
      case FourOfKind =>
      case FullHouse =>
      case Flush =>
      case Straight =>
      case ThreeOfAKind =>
      case TwoPairs =>
      case OnePair =>
      case NoValue =>

    }
  }

}


case class Hand (cards:Seq[Card]){
  require(cards.size == 5)

  val sortedCards = cards.sortWith(Card.sortFunc)

  lazy val highestValue = sortedCards.last.intValue
  lazy val lowestValue = sortedCards(0).intValue

  lazy val rank = if(hasRoyalFlush) {
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

  def hasRoyalFlush = {
    if(sortedCards(0).intValue == 10 && hasStraightFlush){
      true
    }else{
      false
    }

  }


  def hasStraightFlush: Boolean = {
    if(hasFlush && hasStraight){
      true
    }else{
      false
    }

  }

  def hasFourOfAKind: Boolean = {
    val a = findPairs(sortedCards)
    if(a.size == 3 &&
      (a(0)._1.intValue == a(1)._1.intValue && a
      (1)._1.intValue == a(2)._1.intValue)){
      true
    }else{
      false
    }
  }


  def hasFullHouse:Boolean = {
    val a = findPairs(sortedCards)
    if(a.size ==3 &&
      ((a(0)._1.intValue == a(1)._1.intValue && a(1)._1.intValue != a(2)._1.intValue) ||
        (a(0)._1.intValue != a(1)._1.intValue && a(1)._1.intValue == a(2)._1.intValue) )
    ){
      true
    }else{
      false
    }
  }

  def highestOfFullHouse = {
    val a = findPairs(sortedCards)
    if(a.size ==3 ){
      if((a(0)._1.intValue == a(1)._1.intValue && a(1)._1.intValue != a(2)._1.intValue)
        ){
        true
      }else if((a(0)._1.intValue != a(1)._1.intValue && a(1)._1.intValue == a(2)._1.intValue) ){

      }
    }else{
      0
    }


  }

  def hasFlush: Boolean = {
    sortedCards.zip(sortedCards.tail).forall(p => {p._1.kind == p._2.kind})
  }

  def hasStraight: Boolean = {
    sortedCards.zip(sortedCards.tail).forall(p => {p._1.intValue + 1 == p._2.intValue})
  }

  def hasOnePair: Boolean = {
    //    cards.zip(cards.tail).exists(p => {p._1.intValue  == p._2.intValue})
    val a = findPairs(sortedCards)
    if(a.size == 1) true else false
  }

  def highestOfOnePair = {
    val a = findPairs(sortedCards)
    if(a.size == 1){
      a(0)._1.intValue
    }  else {
      0
    }
  }

  def hasTwoPairs: Boolean = {
    //    cards.zip(cards.tail).exists(p => {p._1.intValue  == p._2.intValue})
    val a = findPairs(sortedCards)
    if(a.size == 2 && a(0)._1.intValue != a(1)._1.intValue) true else false
  }

  def highestOfTwoPairs = {
    val a = findPairs(sortedCards)
    if(a.size == 2 && a(0)._1.intValue != a(1)._1.intValue) {
      if(a(0)._1.intValue > a(1)._1.intValue){
        a(0)._1.intValue
      }else{
        a(1)._1.intValue
      }
    } else{
      0
    }
  }

  def hasThreeOfAKind: Boolean = {
    //    cards.zip(cards.tail).exists(p => {p._1.intValue  == p._2.intValue})
    val a = findPairs(sortedCards)
    if(a.size == 2 && a(0)._1.intValue == a(1)._1.intValue) true else false
  }

  def highestOfThreeOfAKind = {
    val a = findPairs(sortedCards)
    if(a.size == 2 && a(0)._1.intValue == a(1)._1.intValue) a(0)._1.intValue else 0

  }


  def highestValueInRank = {
    rank match {
      case RoyalFlush => 0
      case StraightFlush => this.highestValue
      case FourOfKind =>
      case FullHouse =>
      case Flush =>
      case Straight =>
      case ThreeOfAKind =>
      case TwoPairs =>
      case OnePair =>
      case NoValue =>

    }
  }


}


object Game{
  def apply(s:String): Game = {
    val sArr = s.split(" ")
    Game(Hand(sArr.take(5).toSeq.map(Card.apply)), Hand(sArr.takeRight(5).toSeq.map(Card.apply)))
  }

  def findWinner(g:Game) = {

  }
}
case class Game(player1:Hand, player2:Hand){

  lazy val player1Rank = player1.rank
  lazy val player2Rank = player2.rank



  def isPlayer1Winner = {
    if(player1.rank > player2.rank){
      true
    }else if(player1.rank == player2.rank){

    }else{
      false
    }
  }


}
