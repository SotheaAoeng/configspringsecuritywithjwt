package com.merean.spring.boot3.security.controller.auth;

import com.merean.spring.boot3.security.controller.RestApiController;
import com.merean.spring.boot3.security.payload.auth.AuthRequest;
import com.merean.spring.boot3.security.payload.auth.SignUpRequest;
import com.merean.spring.boot3.security.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth")
public class AuthController extends RestApiController {

    private final AuthService authService;

    @PostMapping("/signup")
    public Object signup(@RequestBody @Valid SignUpRequest payload) throws Throwable {
        authService.signup(payload);
        return ok();
    }

    @PostMapping("/login")
    public Object login(@RequestBody @Valid AuthRequest payload) throws Throwable {
        return ok(authService.login(payload));
    }
}
