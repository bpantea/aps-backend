package com.aps.backend.security.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User

class AuthenticationUser(
        username: String?,
        password: String?,
        authorities: MutableCollection<out GrantedAuthority>?
) : User(username, password, authorities) {
    constructor(user: com.aps.backend.users.domain.User) : this(user.email, user.password, mutableListOf<GrantedAuthority>(SimpleGrantedAuthority(user.role.name)))
}
