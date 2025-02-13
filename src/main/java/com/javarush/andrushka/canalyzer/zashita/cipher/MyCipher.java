package com.javarush.andrushka.canalyzer.zashita.cipher;

import com.javarush.andrushka.canalyzer.zashita.fileswork.FileMan;

public class MyCipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final int ALPHABET_LENGTH = ALPHABET.length;
    FileMan  fileManager = new FileMan();

}
