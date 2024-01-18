package com.merean.spring.boot3.security.service.auth;

import com.merean.spring.boot3.security.domain.user.User;
import com.merean.spring.boot3.security.domain.user.UserRepository;
import com.merean.spring.boot3.security.enums.YesOrNo;
import com.merean.spring.boot3.security.payload.auth.AuthRequest;
import com.merean.spring.boot3.security.payload.auth.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    @Override
    public void signup(SignUpRequest payload) throws Throwable {


        var user = User.builder()
                .userId(payload.userId())
                .userPassword(payload.password())
                .userName(payload.fullname())
                .phoneNumber(payload.phonenumber())
                .userAddress(payload.address())
                .userEmail(payload.email())
                .deleteYN(YesOrNo.NO)
                .build();
        userRepository.save(user);
    }

    @Override
    public Object login(AuthRequest payload) throws Throwable {

        return null;
    }

}
