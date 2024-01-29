package com.merean.spring.boot3.security.service.auth;

import com.merean.spring.boot3.security.common.api.StatusCode;
import com.merean.spring.boot3.security.components.security.UserAuthenticationProvider;
import com.merean.spring.boot3.security.domain.user.User;
import com.merean.spring.boot3.security.domain.user.UserRepository;
import com.merean.spring.boot3.security.enums.YesOrNo;
import com.merean.spring.boot3.security.exception.BusinessException;
import com.merean.spring.boot3.security.payload.auth.AuthRequest;
import com.merean.spring.boot3.security.payload.auth.AuthResponse;
import com.merean.spring.boot3.security.payload.auth.SecurityUser;
import com.merean.spring.boot3.security.payload.auth.SignUpRequest;
import com.merean.spring.boot3.security.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final UserAuthenticationProvider authProvider;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignUpRequest payload) throws Throwable {

        var userId = userRepository.findByUserId(payload.userId());
        if (userId.isPresent()) {
            throw new BusinessException(StatusCode.USER_ID_EXIST);
        }
        System.err.println(PasswordUtils.encrypt("sothea"));
        System.err.println(PasswordUtils.decrypt("nj8inSA6wvYtlstZBalG2A=="));
        String rawPassword;
        try {
            rawPassword = passwordEncoder.encode(PasswordUtils.decrypt(payload.password()));
            System.err.println("rw"+ rawPassword);
        } catch (Exception e){
            throw new BusinessException(StatusCode.PASSWORD_MUST_BE_ENCRYPTED);
        }

        var user = User.builder()
                .userId(payload.userId())
                .userPassword(rawPassword)
                .userName(payload.fullname())
                .phoneNumber(payload.phonenumber())
                .userAddress(payload.address())
                .userEmail(payload.email())
                .deleteYN(YesOrNo.NO)
                .activeYN(YesOrNo.YES)
                .lockYN(YesOrNo.NO)
                .build();
        userRepository.save(user);
    }

    @Override
    public Object login(AuthRequest payload) throws Throwable {
        // Perform authentication
        Authentication authenticate = authProvider.authenticate(payload.userId(), payload.password());

        SecurityUser securityUser = (SecurityUser) authenticate.getPrincipal();
        // Set the authenticated user in the SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        // Generate JWT token
        String token = tokenService.generateToken(securityUser);

        // Return the token in the response
        return new AuthResponse(token, "Bearer", tokenService.getExpireIn());
    }

}
