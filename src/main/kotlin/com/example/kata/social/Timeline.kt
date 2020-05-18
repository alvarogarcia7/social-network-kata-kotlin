package com.example.kata.social

class Timeline(private val values: MutableList<Twit> = mutableListOf()) {

    fun store(twit: Twit) = values.add(twit)

    fun last(): Twit = values.last()
}
