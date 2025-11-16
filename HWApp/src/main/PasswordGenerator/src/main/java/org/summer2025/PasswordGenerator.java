package org.summer2025;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static final SecureRandom RANDOM = new SecureRandom();

    public String generatePassword(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Довжина пароля має бути більше 0");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomCharIndex = RANDOM.nextInt(PASSWORD_ALLOW_BASE.length());
            password.append(PASSWORD_ALLOW_BASE.charAt(randomCharIndex));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        int passwordLength = 12;
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String generatedPassword = passwordGenerator.generatePassword(passwordLength);
        System.out.println("Згенерований пароль: " + generatedPassword);
    }
}
