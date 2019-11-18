package com.example.kata.social

class SocialNetworkClient(val console: MyConsole) {
    fun command(rawCommand: String) {
        val isPublish = rawCommand.startsWith("publish ")

        if(isPublish){
            var rest = rawCommand.replace("publish ", "")
            console.println("alice (0s): ${rest}")
        }
    }

}
