package com.aps.backend.users.api

import com.aps.backend.utils.USER_API
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(USER_API)
class UserController {
    @GetMapping
    fun helloWorld(): String {
        return "Hello world!"
    }
}
