package pl.andriejsoft.smrl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmrlApplication

fun main(args: Array<String>) {
    runApplication<SmrlApplication>(*args)
}
