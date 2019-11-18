package com.example.kata.social

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.Test

class SocialNetworkTest {
    companion object {
        val alice = User("alice")
    }


    @Test
    fun `post a twit`() {
        val message = "hola mundo!"
        login(alice)

        postTwit(message)

        val timeline = readTimeline()
        assertThat("alice (0s): $message", Is.`is`(timeline[0]))
    }

    @Test
    fun `post another twit (in Polish!)`() {
        val message = "hola mon!"
        login(alice)

        postTwit(message)

        val timeline = readTimeline()
        assertThat("alice (0s): $message", Is.`is`(timeline[0]))
    }

    private fun login(user: User) {

    }

    private val console: InMemoryConsole = InMemoryConsole()
    private val client: SocialNetworkClient = SocialNetworkClient(console)

    private fun readTimeline(): List<String> {
        client.command("timeline")
        return console.values
    }

    private fun postTwit(rawMessage: String) {
        client.command("publish $rawMessage")
    }

}
