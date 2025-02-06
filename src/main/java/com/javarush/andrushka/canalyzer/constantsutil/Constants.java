package com.javarush.andrushka.canalyzer.constantsutil;

public class Constants {
     private static final String rus = "йфяцычувскамепинртгоьшлщдзжбю";
    private static final  String eng = "qazwsxedcrfvtgbyhnujmiklop";
    private static final String digits = "0123456789";
    private static final String  dMarks = "!@#$%^&*()_+-{}[]:;\"<,>.?/\\";
    public static final String alphabet = rus + eng + rus.toLowerCase() + eng.toLowerCase() + digits + dMarks;
}
