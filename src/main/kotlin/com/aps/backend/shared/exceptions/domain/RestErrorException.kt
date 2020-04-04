package com.aps.backend.shared.exceptions.domain

import java.lang.RuntimeException

open class RestErrorException(message: String) : RuntimeException(message)
