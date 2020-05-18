package com.example.kata.social

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doReturnConsecutively
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.Test
import java.time.LocalDateTime.now
import java.time.Period
import java.time.temporal.ChronoField

class SocialNetworkTest {
    companion object {
        val alice = User("alice")
    }


    @Test
    fun `post a twit`() {
        val message = "hola mundo!"
        login(alice)

        postTwit(message)
        sleep(1)

        val timeline = readTimeline()
        assertThat("alice (1s): $message", Is.`is`(timeline[0]))
    }

    private fun sleep(days: Int) {


    }

    private fun login(user: User) {

    }

    private val console: InMemoryConsole = InMemoryConsole()
    private val clock: Clock = mock {
        on { getTime() } doReturnConsecutively listOf(now().minusSeconds(1), now())
    }
    private val client: SocialNetworkClient = SocialNetworkClient(console, alice, clock)

    private fun readTimeline(): List<String> {
        client.command("timeline")
        return console.values
    }

    private fun postTwit(rawMessage: String) {
        client.command("publish $rawMessage")
    }

}
