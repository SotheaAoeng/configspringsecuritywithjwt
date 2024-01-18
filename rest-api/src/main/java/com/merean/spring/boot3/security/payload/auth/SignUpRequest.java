package com.merean.spring.boot3.security.payload.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SignUpRequest(
//        String taxId,
//        String businessName,
//        String representativeName,

//        String cityCode,
//        String nationalCode,
        String address,
        String fullname,
        String email,
        String phonenumber,
        @JsonProperty("user_id")
        String userId,
        String password
//        String securityCode,
//        String securityKey
) {
}
