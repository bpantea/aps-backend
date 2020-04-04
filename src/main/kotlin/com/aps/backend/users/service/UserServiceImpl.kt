package com.aps.backend.users.service

import com.aps.backend.security.service.SecurityService
import com.aps.backend.users.api.dto.UserDto
import com.aps.backend.users.api.dto.UserSavingDto
import com.aps.backend.users.domain.User
import com.aps.backend.users.domain.UserRole
import com.aps.backend.users.domain.exceptions.EmailAlreadyUsedException
import com.aps.backend.users.repository.UserRepository
import com.aps.backend.users.toUserDto
import com.aps.backend.users.validator.validate
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        private val userRepository: UserRepository,
        private val securityService: SecurityService,
        private val passwordEncoder: PasswordEncoder
) : UserService {
    override fun getUserEntity(): UserDto? {
        return securityService.getUserEntity()?.toUserDto()
    }

    override fun register(userSaving: UserSavingDto): UserDto {
        userSaving.validate()
        if (userRepository.findByEmail(userSaving.email!!) != null) {
            throw EmailAlreadyUsedException()
        }
        var user = User()
        user.email = userSaving.email!!
        user.password = passwordEncoder.encode(userSaving.password)
        user.firstName = userSaving.firstName!!
        user.lastName = userSaving.lastName!!
        user.role = UserRole.USER
        user = userRepository.save(user)
        return user.toUserDto()
    }
}
