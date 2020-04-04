package com.aps.backend.users.services

import com.aps.backend.users.api.dto.UserDto

interface UserService {
    fun getUserEntity(): UserDto
}