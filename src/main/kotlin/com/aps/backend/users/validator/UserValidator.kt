package com.aps.backend.users.validator

import com.aps.backend.shared.validation.ValidationResult
import com.aps.backend.users.api.dto.UserSavingDto

fun UserSavingDto.validate() {
    val validationResult = ValidationResult()
    if (email.isNullOrEmpty()) {
        validationResult.rejectValue("email", "Email cannot be empty")
    }
    // todo: add email validation

    if (firstName.isNullOrEmpty()) {
        validationResult.rejectValue("firstName", "First name cannot be empty")
    }

    if (lastName.isNullOrEmpty()) {
        validationResult.rejectValue("lastName", "Last name cannot be empty")
    }

    if (password.isNullOrEmpty()) {
        validationResult.rejectValue("password", "Password cannot be empty")

        if (matchingPassword.isNullOrEmpty()) {
            validationResult.rejectValue("matchingPassword", "")
        }
    } else {
        if (password != matchingPassword) {
            validationResult.rejectValue("matchingPassword", "Passwords don't match")
        }
    }

    validationResult.rejectIfHasErrors()
}
