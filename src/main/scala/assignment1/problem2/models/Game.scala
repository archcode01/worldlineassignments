/**
  * Copyright (c) Metro Group
  */
package assignment1.problem2.models


object Game{
  def apply(s:String): Game = {
    val sArr = s.split(" ")
    Game(Hand(sArr.take(5).toSeq.map(Card.apply)), Hand(sArr.takeRight(5).toSeq.map(Card.apply)))
  }
}
case class Game(player1:Hand, player2:Hand){

  lazy val player1Rank = player1.rank
  lazy val player2Rank = player2.rank



  def isPlayer1Winner: Boolean = {
    if(player1.rank > player2.rank){
      true
    }else if(player1.rank == player2.rank){
      //if ranks are same compare the int value of ranks
      if(player1.highestValueInRank > player2.highestValueInRank){
        true
      } else if(player1.highestValueInRank > player2.highestValueInRank){
        player1.highestInHand > player2.highestInHand
      }else {
        false
      }
    }else{
      false
    }
  }

  private def player1HasHighestInRankCard: Boolean = {
    player1.highestValueInRank > player2.highestValueInRank
  }


}
