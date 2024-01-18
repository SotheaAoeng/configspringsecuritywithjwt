package com.merean.spring.boot3.security.service.auth;

import com.merean.spring.boot3.security.domain.user.UserRepository;
import com.merean.spring.boot3.security.payload.auth.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    @Override
    public Object login(AuthRequest payload) throws Throwable {
        return null;
    }
}
