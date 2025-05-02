package example

import org.springframework.stereotype.Service

@Service
class HelloWorld {
    fun sayHello(): String {
        return "Hello, World!"
    }
}
