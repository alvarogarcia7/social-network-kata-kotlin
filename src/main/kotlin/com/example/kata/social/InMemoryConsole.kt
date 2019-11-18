package com.example.kata.social

class InMemoryConsole(val values: MutableList<String> = mutableListOf()) : MyConsole {
    override fun println(line: String) {
        values.add(line)
    }
}
