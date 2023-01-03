package org.tennis

class MessageBoard {
    private var value: String = String();

    override fun toString(): String {
        return value;
    }

    fun loveAll() {
        this.value = "Love-All";
    }

    fun fifteenAll() {
        this.value = "Fifteen-All"
    }

    fun thirtyAll() {
        this.value = "Thirty-All"
    }

    fun deuce() {
        this.value = "Deuce"
    }

    fun advantage(player: String) {
        this.value = "Advantage for the player '" + player + "'"
    }

    fun win(player: String) {
        this.value = "Win for player '" + player + "'"
    }

    companion object {
        fun of(): MessageBoard {
            return MessageBoard()
        }
    }

}
