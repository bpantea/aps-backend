package com.aps.backend.shared.validation

import com.aps.backend.shared.exceptions.domain.FieldError
import com.aps.backend.shared.exceptions.domain.ValidationException

class ValidationResult {
    private var fieldErrors: MutableList<FieldError> = mutableListOf()

    fun rejectValue(field: String, error: String) {
        fieldErrors.add(FieldError(field, error))
    }

    fun rejectIfHasErrors() {
        if (fieldErrors.isNotEmpty()) throw ValidationException(fieldErrors)
    }
}
