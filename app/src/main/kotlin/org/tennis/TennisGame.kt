package org.tennis


class TennisGame(player1: Player, player2: Player, messageBoard: MessageBoard) {

    private var player1: Player = player1
    private var player2: Player = player2
    private var messageBoard: MessageBoard = messageBoard

    companion object {
        private const val DISTANCE_TO_WIN = 2
    }

    fun updateResults() {
        if (sameScore()) {
            messageBoard.showSameScoreForAll(player1.getScore())
        } else if (notSameScopeButOutOfWinZone()) {
            messageBoard.showTheScoresFor(player1, player2)
        } else if (player1HasWon()) {
            messageBoard.showTheWinner(player1)
        } else if (player2HasWon()) {
            messageBoard.showTheWinner(player2)
        } else {
            showAdvantageForTheBestPlayer()
        }
    }

    private fun player2HasWon(): Boolean {
        val score1 = player1.getScore()
        val score2 = player2.getScore()
        if (score2.distanceFrom(score1) >= DISTANCE_TO_WIN) {
            messageBoard.showTheWinner(player2)
            return true;
        }
        return false
    }

    private fun player1HasWon(): Boolean {
        val score1 = player1.getScore()
        val score2 = player2.getScore()
        return score1.distanceFrom(score2) >= DISTANCE_TO_WIN
    }

    private fun notSameScopeButOutOfWinZone(): Boolean {
        val score1 = player1.getScore()
        val score2 = player2.getScore()
        return !score1.isInTheWinZone() && !score2.isInTheWinZone()
    }

    private fun sameScore(): Boolean {
        val score1 = player1.getScore()
        val score2 = player2.getScore()
        return score1 == score2
    }

    private fun showAdvantageForTheBestPlayer() {
        if (player2.beterScoreThan(player1)) {
            messageBoard.showAdvantageFor(player2)
        } else {
            messageBoard.showAdvantageFor(player1)
        }
    }
}
