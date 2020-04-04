package com.aps.backend.users.api.dto

data class UserSavingDto(
        var id: Long? = null,
        var email: String? = null,
        var password: String? = null,
        var matchingPassword: String? = null,
        var firstName: String? = null,
        var lastName: String? = null
)
