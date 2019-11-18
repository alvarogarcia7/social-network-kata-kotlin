package com.example.kata.social

class SocialNetworkClient(val console: MyConsole, val user: User) {
    fun command(rawCommand: String) {
        val isPublish = rawCommand.startsWith("publish ")

        if (isPublish) {
            var rest = rawCommand.replace("publish ", "")
            user.publish(rest)
        } else {
            val timeline = user.getTimeline()
            console.println("alice (0s): ${timeline.last()}")
        }
    }

}
