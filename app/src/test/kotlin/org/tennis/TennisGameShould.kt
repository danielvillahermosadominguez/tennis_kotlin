/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.tennis

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import org.tennis.game.MessageBoard
import org.tennis.game.Player
import org.tennis.game.Score
import org.tennis.game.TennisGame

class TennisGameShould {

    private var game: TennisGame? = null;
    private var player1: Player? = null;
    private var player2: Player? = null;
    private var messageBoard: MessageBoard? = null;

    @BeforeEach
    fun beforeEach() {
        this.player1 = Player.of("John", Score())
        this.player2 = Player.of("Mary", Score())
        this.messageBoard = MessageBoard.of()
        this.game = TennisGame(player1!!, player2!!, this.messageBoard!!)
    }

    @Test
    fun `show the message "love-All" when the score is 0-0`() {
        val expectedMessage: String = "Love-All"

        assertThat(messageBoard.toString()).isEqualTo(expectedMessage)
    }

    @Test
    fun `show the message Fifteen-All when the score is 1-1`() {
        val expectedMessage: String = "Fifteen-All"
        setScore(1, 1)

        this.game?.updateResults()

        assertThat(messageBoard.toString()).isEqualTo(expectedMessage)
    }

    @Test
    fun `show the message Thirty-All when the score is 2-2`() {
        val expectedMessage: String = "Thirty-All"
        setScore(2, 2)

        this.game?.updateResults()

        assertThat(messageBoard.toString()).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @ValueSource(ints = [3,4,5,6,7,8,9,10])
    fun `show the message Deuce when the score is equal and more or equal 3`(score:Int) {
        val expectedMessage: String = "Deuce"
        setScore(score, score)

        game?.updateResults()

        assertThat(messageBoard.toString()).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "3,4,Mary",
        "4,3,John",
        "5,4,John",
        "6,5,John",
        "7,6,John",
        "6,7,Mary"
    )
    fun `show the advantage message for a player`(
        scorePlayer1: Int,
        scorePlayer2: Int,
        espectedAdvancedPlayer: String
    ) {
        val expectedMessage: String = "Advantage for the player '" + espectedAdvancedPlayer + "'"

        setScore(scorePlayer1, scorePlayer2)

        game?.updateResults()

        assertThat(messageBoard.toString()).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "1,4,Mary",
        "2,4,Mary",
        "3,5,Mary",
        "4,6,Mary",
        "5,7,Mary",
        "4,1,John",
        "4,2,John",
        "5,3,John",
        "6,4,John",
        "7,5,John",
    )

    fun `show the win message for a player`(
        scorePlayer1: Int,
        scorePlayer2: Int,
        expectedWinner: String
    ) {
        val expectedMessage: String = "Win for player '" + expectedWinner + "'"
        setScore(scorePlayer1, scorePlayer2)

        game?.updateResults()

        assertThat(messageBoard.toString()).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "0,1,John,Mary,Love,Fifteen",
        "0,2,John,Mary,Love,Thirty",
        "1,2,John,Mary,Fifteen,Thirty",
        "2,0,John,Mary,Thirty,Love"
    )

    fun `show the standard message when no player has more than 3 points`(
        scorePlayer1: Int,
        scorePlayer2: Int,
        player1Name: String,
        player2Name: String,
        player1Text: String,
        player2Text: String
    ) {
        val expectedMessage: String = """
            $player1Name - $scorePlayer1 - $player1Text
            $player2Name - $scorePlayer2 - $player2Text
        """.trimIndent()

        setScore(scorePlayer1, scorePlayer2)

        game?.updateResults()

        assertThat(messageBoard.toString()).isEqualTo(expectedMessage)
    }

    private fun setScore(player1Wins: Int, player2Wins: Int) {
        for (i in 0 until player1Wins ) {
            player1?.winPoint()
        }

        for (i in 0 until player2Wins  ) {
            player2?.winPoint()
        }
    }
}
