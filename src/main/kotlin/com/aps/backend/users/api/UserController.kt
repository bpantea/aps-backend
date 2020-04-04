package com.aps.backend.users.api

import com.aps.backend.users.api.dto.UserDto
import com.aps.backend.users.services.UserService
import com.aps.backend.utils.USER_API
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(USER_API)
class UserController(private val userService: UserService) {
    @GetMapping
    fun getFullUser(): UserDto {
        return userService.getUserEntity()
    }

    @GetMapping("/logged-in")
    fun isLoggedIn(): Boolean {
        return true
    }
}
