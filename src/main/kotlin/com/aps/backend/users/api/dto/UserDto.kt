package com.aps.backend.users.api.dto

import com.aps.backend.users.domain.UserRole

data class UserDto(var id: Long = 0,
                   var username: String = "",
                   var email: String? = null,
                   var role: UserRole = UserRole.USER)
