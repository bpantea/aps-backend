package com.aps.backend.shared.exceptions.domain

data class ValidationException(val errors: List<FieldError>) : RuntimeException()
