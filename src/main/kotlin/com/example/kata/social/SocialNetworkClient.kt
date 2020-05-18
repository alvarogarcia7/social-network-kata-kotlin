package com.example.kata.social

class SocialNetworkClient(val console: MyConsole, val user: User, val clock: Clock) {
    fun command(rawCommand: String) {
        val isPublish = rawCommand.startsWith("publish ")

        if (isPublish) {
            var rest = rawCommand.replace("publish ", "")
            user.publish(Twit(rest, clock.getTime()))
        } else {
            val timeline = user.getTimeline()
            val last = timeline.last()

            val differenceInSeconds = calculateRelativeDifferenceInTime(last)

            console.println("${user.name} ($differenceInSeconds): ${last.message}")
        }
    }

    private fun calculateRelativeDifferenceInTime(twit: Twit): String {
        return DifferenceInTime().perform(clock.getTime(), twit.publishedAt).asRelative()
    }

}
