package com.aps.backend.users.services

import com.aps.backend.users.api.dto.UserDto
import com.aps.backend.users.api.dto.UserSavingDto

interface UserService {
    fun getUserEntity(): UserDto

    fun register(userSaving: UserSavingDto): UserDto
}
