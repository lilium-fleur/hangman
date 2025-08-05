package org.example;

public class Validator {
    public static boolean isValid(String str) {
        if (str == null || str.isEmpty() || str.equals(" ")) return false;
        if (str.length() > 1) return false;
        return isRussianLetter(str.charAt(0));
    }

    public static boolean isRussianLetter(char c) {
        return c >= 'а' && c <= 'я' || c >= 'А' && c <= 'Я' || c == 'ё' || c == 'Ё';
    }
}
