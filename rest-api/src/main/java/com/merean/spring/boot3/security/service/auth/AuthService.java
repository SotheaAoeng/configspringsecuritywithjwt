package com.merean.spring.boot3.security.service.auth;

import com.merean.spring.boot3.security.payload.auth.AuthRequest;

public interface AuthService {
    Object login(AuthRequest payload) throws Throwable;
}
