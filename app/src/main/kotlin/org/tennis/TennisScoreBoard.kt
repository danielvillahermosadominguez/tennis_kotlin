package org.tennis

class TennisScoreBoard {
    private companion object {
        const val INITIAL_SCORE = -1
    }
    private var player1Score: Int = INITIAL_SCORE
    private var player2Score: Int = INITIAL_SCORE

    fun showResult(): String {
        if (notStarted()) {
            return String()
        }
        return "Love-All";
    }

    private fun notStarted() = player1Score == INITIAL_SCORE && player2Score == INITIAL_SCORE

    fun setScore(player1Score: Int, player2Score: Int) {
        this.player1Score = player1Score
        this.player2Score = player2Score
    }

}
