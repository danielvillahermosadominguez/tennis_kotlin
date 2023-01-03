package org.tennis

import kotlin.math.abs

class TennisScoreBoard(player1Name: String, player2Name: String) {
    private companion object {
        const val INITIAL_SCORE = -1
    }

    private var player1Score: Int = INITIAL_SCORE
    private var player2Score: Int = INITIAL_SCORE
    private var player1Name: String = player1Name
    private var player2Name: String = player2Name
    fun setScore(player1Score: Int, player2Score: Int) {
        this.player1Score = player1Score
        this.player2Score = player2Score
    }

    fun showResult(): MessageBoard {
        val messageBoard = MessageBoard.of()
        if (notStarted()) {
            return messageBoard
        }

        if (equalScore()) {
            equalScoreMessage(messageBoard)
            return messageBoard
        }

        var advancedPlayer = advantagedPlayer()

        if (advantageOfTwo()) {
            messageBoard.win(advancedPlayer)
            return messageBoard;
        }

        messageBoard.advantage(advancedPlayer)
        return messageBoard
    }

    private fun emptyMessage() = MessageBoard.of()

    private fun advantagedPlayer(): String {
        var advancedPlayer = player1Name
        if (player2Score > player1Score) {
            advancedPlayer = player2Name
        }
        return advancedPlayer
    }

    private fun advantageOfTwo() = abs(player1Score - player2Score) >= 2

    private fun equalScore() = player1Score == player2Score

    private fun equalScoreMessage(messageBoard: MessageBoard) {
        when (player1Score) {
            0 -> messageBoard.loveAll()
            1 -> messageBoard.fifteenAll()
            2 -> messageBoard.thirtyAll()
            else -> messageBoard.deuce()
        }
    }

    private fun notStarted() = player1Score == INITIAL_SCORE && player2Score == INITIAL_SCORE
}
