package com.aps.backend.users.repository

import com.aps.backend.users.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
