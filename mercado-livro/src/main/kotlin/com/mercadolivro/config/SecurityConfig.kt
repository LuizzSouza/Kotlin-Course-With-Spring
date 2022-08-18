package com.mercadolivro.config

import com.mercadolivro.repository.CustomerRepository
import com.mercadolivro.security.AuthenticationFilter
import com.mercadolivro.service.UserDetailsCustomService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customerRepository: CustomerRepository,
    private val userDetails: UserDetailsCustomService
) : WebSecurityConfigurerAdapter() {

    private val PUBLIC_MATCHERS = arrayOf<String>()

    private val PUBLIC_POST_MATCHERS = arrayOf(
        "/customer"
    )

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetails).passwordEncoder(bCryptPasswordEncoder())
    }

    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable()
        http.authorizeRequests()
            .antMatchers(*PUBLIC_MATCHERS).permitAll()
            .antMatchers(HttpMethod.POST, *PUBLIC_POST_MATCHERS).permitAll()
            .anyRequest().authenticated()
        http.addFilter(AuthenticationFilter(authenticationManager(), customerRepository))
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    override fun configure(web: WebSecurity) {
        web.ignoring()
            .antMatchers(
                "/v2/api-docs",
                "/v3/api-docs",
                "/mercado-livro-api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui/**",
                "/webjars/**",
                "/csrf/**"
            )
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}