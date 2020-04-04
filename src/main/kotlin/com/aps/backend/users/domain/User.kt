package com.aps.backend.users.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var email: String = "",
        var password: String = "",
        var firstName: String = "",
        var lastName: String = "",
        var role: UserRole = UserRole.USER
)
