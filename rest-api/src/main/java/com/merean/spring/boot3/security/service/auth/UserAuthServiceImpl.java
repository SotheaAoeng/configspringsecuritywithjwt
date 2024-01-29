package com.merean.spring.boot3.security.service.auth;

import com.merean.spring.boot3.security.domain.user.UserRepository;
import com.merean.spring.boot3.security.payload.auth.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * @param username the username identifying the user whose data is required.
     * @return SecurityUser
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new SecurityUser(user);
    }
}
