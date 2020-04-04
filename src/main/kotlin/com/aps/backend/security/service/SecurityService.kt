package com.aps.backend.security.service

import com.aps.backend.security.domain.AuthenticationUser
import com.aps.backend.users.domain.User
import org.springframework.security.core.userdetails.UserDetailsService

interface SecurityService : UserDetailsService {
    fun getAuthenticationUser(): AuthenticationUser?

    fun getUserEntity(): User?
}
