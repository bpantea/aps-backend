package com.aps.backend.shared.exceptions.handler

import com.aps.backend.shared.exceptions.domain.ValidationException
import com.aps.backend.shared.exceptions.domain.ValidationExceptionDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ValidationExceptionHandler {
    @ExceptionHandler(ValidationException::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleRestValidationException(exception: ValidationException): ValidationExceptionDto {
        return ValidationExceptionDto(exception.errors)
    }
}
