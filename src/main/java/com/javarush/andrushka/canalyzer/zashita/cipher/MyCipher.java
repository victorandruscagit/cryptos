package com.javarush.andrushka.canalyzer.zashita.cipher;

import com.javarush.andrushka.canalyzer.fileswork.FileManger;

import java.util.ArrayList;
import java.util.List;

public class MyCipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final int ALPHABET_LENGTH = ALPHABET.length;

    private int arrayIndex(Character symbol) {
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            if (ALPHABET[i] == symbol) {
                return i;
            }
        }
        return -1;
    }

    FileManger fileManager = new FileManger();


    public void encrypt(String inputFile, int key) {
        List<String> outpFi = new ArrayList<>();
        List<String> fileLines = fileManager.readFileLines(inputFile);
        for (String fileLine : fileLines) {
            outpFi.add(replace(fileLine, key));
        }
    }

    public void decrypt(String inputFile, int key) {

    }

    public void bruteForce(String inputFile) {


    }

    public String replace(String line, int key) {

        int startIndex;
        int endIndex;
        char symbol;
        String result = "";

        for (int i = 0; i < line.length(); i++) {

            symbol = line.charAt(i);
            startIndex = arrayIndex(Character.toLowerCase(symbol));

            if ((startIndex == -1) || (symbol == '0')) {
                continue;
            }

            if (key > 0) {

                if (startIndex + key < ALPHABET_LENGTH) {
                    endIndex = startIndex + key;
                } else {
                    endIndex = key - (ALPHABET_LENGTH - startIndex);
                }

                if (Character.isUpperCase(symbol)) {
                    if (endIndex >= 32) {
                        result = result + ALPHABET[endIndex] + '0';
                    } else {
                        result = result + Character.toUpperCase(ALPHABET[endIndex]);
                    }
                } else {
                    result = result + ALPHABET[endIndex];
                }

            } else {

                if (startIndex + key >= 0) {
                    endIndex = startIndex + key;
                } else {
                    endIndex = ALPHABET_LENGTH + startIndex + key;
                }

                if (Character.isUpperCase(symbol)) {
                    result = result + Character.toUpperCase(ALPHABET[endIndex]);
                } else {
                    if (startIndex >= 32) {
                        if (i != line.length() - 1) {
                            if (line.charAt(i + 1) == '0') {
                                result = result + Character.toUpperCase(ALPHABET[endIndex]);
                            } else {
                                result = result + ALPHABET[endIndex];
                            }
                        }
                    } else {
                        result = result + ALPHABET[endIndex];
                    }
                }
            }
        }
        return result;
    }
}
