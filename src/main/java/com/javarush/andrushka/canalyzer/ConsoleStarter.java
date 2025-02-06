package com.javarush.andrushka.canalyzer;

import java.util.Arrays;

public class ConsoleStarter {
    public static void main(String[] args) {
        String rus = "йфяцычувскамепинртгоьшлщдзжбю";
        String eng = "qazwsxedcrfvtgbyhnujmiklop";
        String digitis = "0123456789";
        String dMarks = "!@#$%^&*()_+-{}[]:;\"<,>.?/\\";
        String alphabet = rus + eng + rus.toLowerCase() + eng.toLowerCase() + digitis + dMarks;
        int key = 111;
        String text = "Just a text";
        String result = "";
        System.out.println(Arrays.toString(args));

    }
}
