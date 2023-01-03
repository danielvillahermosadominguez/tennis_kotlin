package org.tennis

class TennisScoreBoard {
    private companion object {
        const val INITIAL_SCORE = -1
    }

    private var player1Score: Int = INITIAL_SCORE
    private var player2Score: Int = INITIAL_SCORE

    fun setScore(player1Score: Int, player2Score: Int) {
        this.player1Score = player1Score
        this.player2Score = player2Score
    }

    fun showResult(): String {
        if (notStarted()) {
            return String()
        }

        if (equalsAndNotZero()) {
            when (player1Score) {
                1 -> return "Fifteen-All"
                2 -> return "Thirty-All"
                else -> return "Deuce"
            }
        }

        return "Love-All";
    }

    private fun equalsAndNotZero() = player1Score > 0 && player1Score == player2Score
    private fun notStarted() = player1Score == INITIAL_SCORE && player2Score == INITIAL_SCORE
}
