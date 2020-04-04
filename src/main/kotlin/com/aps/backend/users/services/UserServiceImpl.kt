package com.aps.backend.users.services

import com.aps.backend.security.service.SecurityService
import com.aps.backend.users.api.dto.UserDto
import com.aps.backend.users.api.dto.UserSavingDto
import com.aps.backend.users.domain.User
import com.aps.backend.users.domain.UserRole
import com.aps.backend.users.domain.exceptions.EmailAlreadyUsedException
import com.aps.backend.users.repository.UserRepository
import com.aps.backend.users.toUserDto
import com.aps.backend.users.validator.validate
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        private val userRepository: UserRepository,
        private val securityService: SecurityService
) : UserService {
    override fun getUserEntity(): UserDto {
        val currentUser = securityService.getUserEntity()!!
        return currentUser.toUserDto()
    }

    override fun register(userSaving: UserSavingDto): UserDto {
        userSaving.validate()
        if (userRepository.findByEmail(userSaving.email!!) != null) {
            throw EmailAlreadyUsedException()
        }
        var user = User(0, userSaving.email!!, userSaving.password!!, userSaving.firstName!!, userSaving.lastName!!, UserRole.USER)
        user = userRepository.save(user)
        return user.toUserDto()
    }
}
