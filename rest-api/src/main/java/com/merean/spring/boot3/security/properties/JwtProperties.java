package com.merean.spring.boot3.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
        @DurationUnit(ChronoUnit.SECONDS)
        Duration expiration
) {
}
