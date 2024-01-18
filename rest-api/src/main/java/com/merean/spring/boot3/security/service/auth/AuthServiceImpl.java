package com.merean.spring.boot3.security.service.auth;

import com.merean.spring.boot3.security.payload.auth.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{


    @Override
    public Object login(AuthRequest payload) throws Throwable {
        return null;
    }
}
