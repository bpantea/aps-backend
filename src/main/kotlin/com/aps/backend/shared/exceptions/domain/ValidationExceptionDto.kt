package com.aps.backend.shared.exceptions.domain

data class ValidationExceptionDto(val errors: List<FieldError>)
