package com.merean.spring.boot3.security.common.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record EmptyJsonResponse() {
}
