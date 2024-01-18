package com.merean.spring.boot3.security.payload.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequest(

        @NotBlank
        @Size(max = 50)
        @JsonProperty("user_id")
        String userId,

        @NotBlank
        @Size(max = 150)
        @JsonProperty("password")
        String password
) {
}
