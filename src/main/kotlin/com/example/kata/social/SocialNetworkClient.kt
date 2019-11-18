package com.example.kata.social

class SocialNetworkClient(val console: MyConsole) {
    fun command(rawCommand: String) {
        console.println("alice (0s): hola mundo!")
    }

}
