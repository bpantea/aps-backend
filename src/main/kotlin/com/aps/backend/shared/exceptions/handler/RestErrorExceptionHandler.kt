package com.aps.backend.shared.exceptions.handler

import com.aps.backend.shared.exceptions.domain.RestErrorException
import com.aps.backend.shared.exceptions.domain.RestErrorExceptionDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class RestErrorExceptionHandler {
    @ExceptionHandler(RestErrorException::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun handleRestErrorException(exception: RestErrorException): RestErrorExceptionDto {
        return RestErrorExceptionDto(exception.message!!)
    }
}
