package com.aps.backend.users.api.dto

import com.aps.backend.users.domain.UserRole

data class UserDto(var id: Long = 0,
                   var email: String = "",
                   var firstName: String = "",
                   var lastName: String = "",
                   var role: UserRole = UserRole.USER)
