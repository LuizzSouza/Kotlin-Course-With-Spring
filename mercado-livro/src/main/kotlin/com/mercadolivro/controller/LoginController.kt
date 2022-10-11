package com.mercadolivro.controller

import com.mercadolivro.controller.request.LoginRequest
import com.mercadolivro.security.JwtUtil
import com.mercadolivro.service.CustomerService
import com.mercadolivro.service.UserDetailsCustomService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("auth")
@Tag(name = "1 - Authentication", description = "Authentication API")
class LoginController(
        val authenticationManager: AuthenticationManager,
        val jwtUtil: JwtUtil,
        val customerService: CustomerService
) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): String? {
        val id = customerService.findIdByEmail(loginRequest.email)
        val authToken = UsernamePasswordAuthenticationToken(id, loginRequest.password)
        authenticationManager.authenticate(authToken)
        return jwtUtil.generateToken(id)
    }

}