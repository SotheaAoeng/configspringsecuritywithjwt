package com.merean.spring.boot3.security.controller.auth;

import com.merean.spring.boot3.security.payload.auth.AuthRequest;
import com.merean.spring.boot3.security.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public Object createUser(@RequestBody @Valid AuthRequest payload) throws Throwable {
        return authService.login(payload);
    }
}
