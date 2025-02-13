package com.javarush.andrushka.canalyzer.zashita.mains;

import com.javarush.andrushka.canalyzer.zashita.cipher.MyCipher;

import java.util.Scanner;

public class MainClass {
    public static final String INPUT_FILE_MESSAGE = "Type in path to file ... :";
    public static final String INPUT_KEY_MESSAGE = "Type the key ... :";
    public static final String ERROR_FILE_MESSAGE = "ERRROR : File you look for doesn't exists/is empty/dosent meet format";
    public static final String ERROR_KEY_MESSAGE = "ERROR : Entered key is beyond boundaries";
    public static final String ERROR_MENU_MESSAGE = "Not supprted action";

    public static void main(String[] args) {
        MyCipher myCipher = new MyCipher();
        Scanner scanner = new Scanner(System.in);
        String  inputFile;
        int key;
        while (true) {
            System.out.println("Choose an option" +
                    "\n 1 - Encrypt the file" +
                    "\n 2 - Decrytp the file" +
                    "\n 3 - Decrypt file via brute force attack" +
                    "\n 4 - ");
        }
    }
}
