package com.example.kata.social

class Timeline(private val values: MutableList<String> = mutableListOf()) {

    fun store(twit: String) = values.add(twit)

    fun last(): String = values.last()
}
