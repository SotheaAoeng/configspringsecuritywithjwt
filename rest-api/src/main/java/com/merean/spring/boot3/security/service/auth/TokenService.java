package com.merean.spring.boot3.security.service.auth;

import com.merean.spring.boot3.security.payload.auth.SecurityUser;
import com.merean.spring.boot3.security.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TokenService {

    private final JwtEncoder encoder;
    private final JwtProperties jwtConfig;

    public long getExpireIn(){
        return jwtConfig.expiration().getSeconds();
    }

//    public String doGenerateToken(SecurityUser securityUser){
//
//        Instant instant= Instant.now();
//
//        Map<String, Object> claim = new HashMap<>();
//        claim.put("name", securityUser.getUsername());
//        claim.put("scope", securityUser.user().getUserRole());
//
//        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
//                .subject(securityUser.getUsername())
//                .issuedAt(instant)
//                .expiresAt(instant.plus(jwtConfig.expiration().getSeconds(), ChronoUnit.SECONDS))
//                .claims(c -> c.putAll(claim))
//                .build();
//
//        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
//    }

    public String generateToken(SecurityUser securityUser) {
        Instant now = Instant.now();
        String scope = securityUser.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
//                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(jwtConfig.expiration().getSeconds(), ChronoUnit.SECONDS))
//                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(securityUser.getUsername())
                .claim("scope", scope)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
