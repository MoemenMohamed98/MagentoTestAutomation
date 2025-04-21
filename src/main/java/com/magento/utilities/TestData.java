package com.magento.utilities;

import com.github.javafaker.Faker;

public class TestData {
    private TestData() {
        // Prevent instantiation of this utility class
    }

    private static final Faker faker = new Faker();

    public static final String FAKE_EMAIL = faker.internet().emailAddress();
    public static final String FAKE_FIRST_NAME = faker.name().firstName();
    public static final String FAKE_LAST_NAME = faker.name().lastName();
    public static final String FAKE_PASSWORD = faker.internet().password(8, 12, true, true);
    public static final String FAKE_CONFIRM_PASSWORD = faker.internet().password(8, 12, true, true);
}
