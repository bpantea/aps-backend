package com.aps.backend.users.domain.exceptions

import com.aps.backend.shared.exceptions.domain.RestErrorException

class EmailAlreadyUsedException : RestErrorException("Email already used")
