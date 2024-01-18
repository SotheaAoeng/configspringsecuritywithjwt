package com.merean.spring.boot3.security.service.auth;

import com.merean.spring.boot3.security.payload.auth.AuthRequest;
import com.merean.spring.boot3.security.payload.auth.SignUpRequest;

public interface AuthService {
    Object login(AuthRequest payload) throws Throwable;

    void signup(SignUpRequest payload) throws Throwable;
}
