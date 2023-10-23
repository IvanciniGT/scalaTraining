package com.training
package game

trait GameStatus {
  private var _winner: Winner.Winner = _

  def winner(): Option[Winner.Winner] = Option(this._winner) //if (this._winner == null) None else Some(this._winner)

  def winner(winner: Winner.Winner): Unit = this._winner = winner

  def isGameOver(): Boolean = this.winner().isDefined

}
