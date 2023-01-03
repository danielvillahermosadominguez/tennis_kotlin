package org.tennis.game

class Player private constructor(val _name:String, var _score: Score) {
    private val name: String = _name
    private var score: Score = _score

    fun betterScoreThan(player: Player): Boolean {
        return score.getValue() > player.getScore().getValue()
    }

    fun getScore(): Score {
        return score
    }

    fun getName(): String {
        return name;
    }

    fun winPoint() {
        score.newPoint()
    }

    companion object {
        fun of(name: String, score: Score): Player {
            return Player(name,score)
        }
    }
}
