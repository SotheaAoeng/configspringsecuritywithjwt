package com.merean.spring.boot3.security.common.api;

import lombok.Getter;

@Getter
public enum StatusCode {

    SUCCESS(200, "Success"),

    PASSWORD_MUST_BE_ENCRYPTED(400, "Password must be encrypted!"),
    USER_LOCKED(400, "User account is locked"),
    USER_ID_EXIST(409, "User ID already exist"),
    BAD_CREDENTIALS(452, "Password is incorrect"),
    USER_NOT_FOUND(453, "User is not found"),
    USER_DISABLED(453, "User account is disabled")

    ;

    private final String message;
    private final int code;

    StatusCode(final int code, final String message) {
        this.message = message;
        this.code = code;
    }

}
