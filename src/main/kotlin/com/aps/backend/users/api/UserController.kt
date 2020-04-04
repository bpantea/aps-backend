package com.aps.backend.users.api

import com.aps.backend.shared.utils.USER_API
import com.aps.backend.users.api.dto.UserDto
import com.aps.backend.users.api.dto.UserSavingDto
import com.aps.backend.users.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(USER_API)
class UserController(private val userService: UserService) {
    @GetMapping
    fun getFullUser(): UserDto {
        return userService.getUserEntity()
    }

    @GetMapping("/logged-in")
    fun isLoggedIn(): Boolean {
        return true
    }

    @PostMapping("/register")
    fun register(@RequestBody user: UserSavingDto): UserDto {
        return userService.register(user)
    }

    @GetMapping("/register")
    fun checkIfRegisterWorks(): String {
        return "works"
    }
}
