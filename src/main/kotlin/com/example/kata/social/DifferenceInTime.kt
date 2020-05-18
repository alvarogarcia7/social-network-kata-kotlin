package com.example.kata.social

import java.time.Duration
import java.time.LocalDateTime

class DifferenceInTime {
    fun perform(originDate: LocalDateTime, endDate: LocalDateTime): MyDuration {
        return MyDuration(Duration.between(endDate, originDate).toSeconds())
    }

    class MyDuration(private val toSeconds: Long) {
        fun asRelative(): String {
            return this.toSeconds.toString() + "s"
        }

    }

}
