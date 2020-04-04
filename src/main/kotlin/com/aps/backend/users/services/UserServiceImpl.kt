package com.aps.backend.users.services

import com.aps.backend.users.api.dto.UserDto
import com.aps.backend.users.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        private val userRepository: UserRepository
) : UserService {
    override fun getUserEntity(): UserDto {
        TODO()
    }

    override fun register(user: UserDto) {
        TODO("Not yet implemented")
    }
}
