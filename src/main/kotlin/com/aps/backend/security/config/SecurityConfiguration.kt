package com.aps.backend.security.config

import com.aps.backend.shared.utils.USER_API
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(*UNAUTHENTICATED_API_ROUTES).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
    }
}

val UNAUTHENTICATED_API_ROUTES = arrayOf(
        "$USER_API/register"
)
