package com.merean.spring.boot3.security.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import converts.AbstractEnumConverter;
import enums.GenericEnum;

import java.util.stream.Stream;

/**
 * A class can be used for getting UserRole enum
 */

public enum UserRole implements GenericEnum<UserRole, String> {
    USER("USER"),
    ADMIN("ADMIN"),
    ;

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    /**
     * Method getValue  : Get Enum value
     * @return Enum value
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Method getLabel  : Get Enum Label
     * @return Enum Label
     */
    @Override
    public String getLabel() {

        if("USER".equals(value)){
            return "User";
        }
        else if("ADMIN".equals(value)){
            return "Admin";
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Method fromValue : Check Enum value
     *
     * @param value  value that have to check
     * @return enum value
     */

    @JsonCreator
    public static UserRole fromValue(String value) {
        return Stream.of(UserRole.values()).filter(targetEnum -> targetEnum.value.equals(value)).findFirst().orElse(null);
    }

    public static class Converter extends AbstractEnumConverter<UserRole, String> {

        public Converter() {
            super(UserRole.class);
        }
    }
}
