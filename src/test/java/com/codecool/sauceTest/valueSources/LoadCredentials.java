package com.codecool.sauceTest.valueSources;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LoadCredentials {

    private static final String USERNAME_REQUIRED = "Epic sadface: Username is required";
    private static final String PW_REQUIRED = "Epic sadface: Password is required";
    private static final String NOT_MATCHED = "Epic sadface: Username and password do not match any user in this service";
    private static final String LOCKED_OUT = "Epic sadface: Sorry, this user has been locked out.";
    private static final String FIRST_NAME_REQUIRED = "Error: First Name is required";
    private static final String LAST_NAME_REQUIRED = "Error: Last Name is required";
    private static final String ZIP_CODE_REQUIRED = "Error: Postal Code is required";

    public static Stream<Arguments> loadUsernames() {
        return  Stream.of(
                Arguments.of("standard_user", "https://www.saucedemo.com/inventory.html" ),
                Arguments.of("problem_user", "https://www.saucedemo.com/inventory.html" ),
                Arguments.of("performance_glitch_user", "https://www.saucedemo.com/inventory.html" ),
                Arguments.of("error_user",  "https://www.saucedemo.com/inventory.html"  ),
                Arguments.of("visual_user", "https://www.saucedemo.com/inventory.html" )
        );
    }

    public static Stream<Arguments> loadInvalidUsername() {

        return  Stream.of(
        Arguments.of("", "https://www.saucedemo.com/", USERNAME_REQUIRED),
        Arguments.of("a", "https://www.saucedemo.com/", NOT_MATCHED),
        Arguments.of("locked_out_user", "https://www.saucedemo.com/", LOCKED_OUT)
                );
    }

    public static Stream<Arguments> loadInvalidPassword() {
        return  Stream.of(
                Arguments.of("standard_user", "", "https://www.saucedemo.com/", PW_REQUIRED),
                Arguments.of("standard_user", "a", "https://www.saucedemo.com/", NOT_MATCHED),
                Arguments.of("locked_out_user", "", "https://www.saucedemo.com/", PW_REQUIRED),
                Arguments.of("locked_out_user", "a", "https://www.saucedemo.com/", NOT_MATCHED),
                Arguments.of("problem_user", "", "https://www.saucedemo.com/", PW_REQUIRED),
                Arguments.of("problem_user", "a", "https://www.saucedemo.com/", NOT_MATCHED),
                Arguments.of("performance_glitch_user", "", "https://www.saucedemo.com/", PW_REQUIRED),
                Arguments.of("performance_glitch_user", "a", "https://www.saucedemo.com/", NOT_MATCHED),
                Arguments.of("error_user", "", "https://www.saucedemo.com/", PW_REQUIRED),
                Arguments.of("error_user", "a", "https://www.saucedemo.com/", NOT_MATCHED),
                Arguments.of("visual_user", "", "https://www.saucedemo.com/", PW_REQUIRED),
                Arguments.of("visual_user", "a", "https://www.saucedemo.com/", NOT_MATCHED)
        );
    }

    public static Stream<Arguments> loadValidBuyerCredentials() {
        return  Stream.of(
                Arguments.of("standard_user", "Drót", "Feszület", "1234", "Thank you for your order!"),
                Arguments.of("problem_user", "Drót", "Feszület", "1234", "Thank you for your order!"),
                Arguments.of("performance_glitch_user", "Drót", "Feszület", "1234", "Thank you for your order!"),
                Arguments.of("error_user", "Drót", "Feszület", "1234", "Thank you for your order!"),
                Arguments.of("visual_user", "Drót", "Feszület", "1234", "Thank you for your order!")
        );
    }

    public static Stream<Arguments> loadInvalidBuyerCredentials() {
        return Stream.of(
                Arguments.of("standard_user", "", "LastName", "1234", FIRST_NAME_REQUIRED),
                Arguments.of("problem_user", "", "LastName", "1234", FIRST_NAME_REQUIRED),
                Arguments.of("performance_glitch_user", "", "LastName", "1234", FIRST_NAME_REQUIRED),
                Arguments.of("error_user", "", "LastName", "1234", FIRST_NAME_REQUIRED),
                Arguments.of("visual_user", "", "LastName", "1234", FIRST_NAME_REQUIRED),
                Arguments.of("standard_user", "FirstName", "", "1234", LAST_NAME_REQUIRED),
                Arguments.of("problem_user", "FirstName", "", "1234", LAST_NAME_REQUIRED),
                Arguments.of("performance_glitch_user", "FirstName", "", "1234", LAST_NAME_REQUIRED),
                Arguments.of("error_user", "FirstName", "", "1234", LAST_NAME_REQUIRED),
                Arguments.of("visual_user", "FirstName", "", "1234", LAST_NAME_REQUIRED),
                Arguments.of("standard_user", "FirstName", "LastName", "", ZIP_CODE_REQUIRED),
                Arguments.of("problem_user", "FirstName", "LastName", "", ZIP_CODE_REQUIRED),
                Arguments.of("performance_glitch_user", "FirstName", "LastName", "", ZIP_CODE_REQUIRED),
                Arguments.of("error_user", "FirstName", "LastName", "", ZIP_CODE_REQUIRED),
                Arguments.of("visual_user", "FirstName", "LastName", "", ZIP_CODE_REQUIRED)
        );
    }
}
