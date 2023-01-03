package org.tennis

import kotlin.math.abs

class Score (value:Int = 0) {
    fun getValue(): Int {
        return value;
    }

    fun newPoint() {
        this.value++
    }

    fun isInTheWinZone(): Boolean {
        return this.value >= 3
    }

    private var value:Int = value

    override fun equals(other: Any?): Boolean {
        val o: Score = other as Score
        return o.getValue() == this.value
    }

    fun distanceFrom(other: Score): Int {
        return value - other.getValue()
    }
}
