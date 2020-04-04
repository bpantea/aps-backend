package com.aps.backend.security.service

import com.aps.backend.security.domain.AuthenticationUser
import com.aps.backend.users.domain.User
import com.aps.backend.users.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class SecurityServiceImpl(
        private val userRepository: UserRepository
) : SecurityService {
    override fun getAuthenticationUser(): AuthenticationUser? {
        val securityContext = SecurityContextHolder.getContext()
        val principal = securityContext.authentication?.principal
        return if (principal is AuthenticationUser) {
            principal
        } else {
            null
        }
    }

    override fun getUserEntity(): User? {
        val user = getAuthenticationUser() ?: return null
        return userRepository.findByEmail(user.username)
    }

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email) ?: throw UsernameNotFoundException("$email not found")
        return AuthenticationUser(user)
    }
}
