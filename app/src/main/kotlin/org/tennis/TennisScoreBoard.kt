package org.tennis

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

    fun showResult(): String {
        if (notStarted()) {
            return String()
        }

        if (player1Score == player2Score) {
            return equalScoreMessage()
        }

        var advancedPlayer = player1Name
        if (player2Score > player1Score) {
            advancedPlayer = player2Name
        }
        return "Advantage for the player '$advancedPlayer'";
    }

    private fun equalScoreMessage(): String {
        when (player1Score) {
            0 -> return "Love-All"
            1 -> return "Fifteen-All"
            2 -> return "Thirty-All"
            else -> return "Deuce"
        }
    }

    private fun notStarted() = player1Score == INITIAL_SCORE && player2Score == INITIAL_SCORE
}
