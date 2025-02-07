package com.javarush.andrushka.canalyzer.constantsutil;

import java.io.File;

public class Constants {
    private static final String RUS = "йфяцычувскамепинртгоьшлщдзжбю";
    private static final String ENG = "qazwsxedcrfvtgbyhnujmiklop";
    private static final String DIGITS = "0123456789";
    private static final String D_MARKS = "!@#$%^&*()_+-{}[]:;\"<,>.?/\\";
    public static final String ALPHABET = RUS + ENG + RUS.toLowerCase() + ENG.toLowerCase() + DIGITS + D_MARKS;
    public static final String TXT_FOLDER =
            System.getProperty("user.dir") + File.separator +
                    "text" + File.separator;
}
