package org.tennis

class MessageBoard {
    private var value: String = String();

    companion object {
        fun of(): MessageBoard {
            var result = MessageBoard()
            result.showSameScoreForAll(Score())
            return result
        }
    }

    fun showSameScoreForAll(score:Score) {
        this.value = scoreToText(score)

        if (!score.isInTheWinZone()) {
            this.value += "-All"
        }
    }

    fun showAdvantageFor(player: Player) {
        this.value = "Advantage for the player '" + player.getName() + "'"
    }

    fun showTheWinner(player: Player) {
        var name = player.getName()
        this.value = "Win for player '" + name + "'"
    }

    fun showTheScoresFor(player1:Player, player2:Player) {
        val scorePlayer1 = player1.getScore()
        val scorePlayer2 = player2.getScore()
        this.value = """
            ${player1.getName()} - ${scorePlayer1.getValue()} - ${scoreToText(scorePlayer1)}
            ${player2.getName()} - ${scorePlayer2.getValue()} - ${scoreToText(scorePlayer2)}
        """.trimIndent()
    }

    override fun toString(): String {
        return value;
    }

    private fun scoreToText(score: Score): String {
        when (score.getValue()) {
            0 -> return "Love"
            1 -> return "Fifteen"
            2 -> return "Thirty"
        }
        return "Deuce"
    }
}
