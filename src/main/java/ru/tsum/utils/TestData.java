package ru.tsum.utils;

/**
 * TestData
 *
 * Generate test data
 *
 * @author Alexander_Suvorov
 */
public class TestData {
    public String getRandomEmail() {
        return String.format("AutoTest_%s@gmail.com", (int) (Math.random() * 100000));
    }

    public String getRandomPassword() {
        return String.format("Password_%s", (int) (Math.random() * 100000));
    }
}
