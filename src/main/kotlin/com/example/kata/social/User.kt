package com.example.kata.social

data class User(val name: String, private val timeline: Timeline = Timeline()) {

    fun publish(twit: Twit) {
        timeline.store(twit)
    }

    fun getTimeline(): Timeline {
        return timeline
    }
}
