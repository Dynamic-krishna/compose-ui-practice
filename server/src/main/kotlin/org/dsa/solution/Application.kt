package org.dsa.solution

import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    install(ContentNegotiation) {
        json()
    }

    routing {
        post("/register") {
/*            val credentials = call.receive<UserCredentials>()
            if (registerUser(credentials.username, credentials.password)) {
                call.respondText("User registered successfully")
            } else {
                call.respondText("User registration failed")
            }*/

            call.respondText("Hello, good day my friend")
        }

    }
}


data class UserCredentials(val username: String, val password: String)