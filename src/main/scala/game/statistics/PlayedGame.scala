package com.training
package game.statistics

import game.Game
import game.Winner

import java.time.LocalDateTime
class PlayedGame(val game: String, val result: Winner.Winner, val date: LocalDateTime)