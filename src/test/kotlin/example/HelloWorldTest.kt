package example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HelloWorldTest {

    private val helloWorld = HelloWorld()

    @Test
    fun testSayHello() {
        assertEquals("Hello, World!", helloWorld.sayHello())
    }
}
