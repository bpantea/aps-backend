package com.aps.backend.users

import com.aps.backend.users.api.dto.UserDto
import com.aps.backend.users.domain.User

fun User.toUserDto(): UserDto {
    return UserDto(id, username, email, role)
}
