package com.training
package game

import org.scalatest.funspec.FunSpec
import statistics._

object ApplicationUIFake extends ApplicationUI {
  override def askToPlayAgain(): PlayAgainResponse.Response = PlayAgainResponse.QUIT
  override def getGameToPlay(games: List[Game]): Game = games.head
  override def getPlayerName(): String = "Me"
}

object PlayerStatisticsRepositorySpy extends PlayerStatisticsRepository {
  var player: Player = null
  var game: Game = null
  var result: Winner.Winner = null
  override def newGame(player: Player, game: Game, result: Winner.Winner): Unit = {
    this.player = player
    this.game = game
    this.result = result
  }
  override def getStatistics(player: Player): List[PlayedGame] = List()
}

object GameFakeLooser extends Game {
  override def play(player: Player): Winner.Winner = Winner.Computer
  override def getGameName(): String = "FakeGame"
}
object GameFakeWinner extends Game {
  override def play(player: Player): Winner.Winner = Winner.Player
  override def getGameName(): String = "FakeGame"
}
object GameApplicationFake extends GameApplication(ApplicationUIFake, PlayerStatisticsRepositorySpy)


class GameApplicationTest extends FunSpec {

    describe("startPlaying") {
      it("when playing, user statistics should be updated") {
        GameApplicationFake.startPlaying(List(GameFakeLooser))
        assert(PlayerStatisticsRepositorySpy.player.name == "Me")
        assert(PlayerStatisticsRepositorySpy.game.getGameName() == "FakeGame")
        assert(PlayerStatisticsRepositorySpy.result == Winner.Computer)


        GameApplicationFake.startPlaying(List(GameFakeWinner))
        assert(PlayerStatisticsRepositorySpy.player.name == "Me")
        assert(PlayerStatisticsRepositorySpy.game.getGameName() == "FakeGame")
        assert(PlayerStatisticsRepositorySpy.result == Winner.Player)
      }
    }

}
