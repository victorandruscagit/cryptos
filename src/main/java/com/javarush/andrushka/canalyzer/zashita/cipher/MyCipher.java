package com.javarush.andrushka.canalyzer.zashita.cipher;

import com.javarush.andrushka.canalyzer.fileswork.FileManger;

import java.io.IOException;

public class MyCipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final int ALPHABET_LENGTH = ALPHABET.length;
    FileManger fileManager = new FileManger();


    public void encrypt(String inputFile, int key) {
        try {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void decrypt(String inputFile, int key) {

    }

    public void bruteForce(String inputFile) {


    }
}
