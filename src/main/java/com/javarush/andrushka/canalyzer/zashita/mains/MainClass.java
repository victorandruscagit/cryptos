package com.javarush.andrushka.canalyzer.zashita.mains;

import com.javarush.andrushka.canalyzer.zashita.cipher.MyCipher;
import com.javarush.andrushka.canalyzer.zashita.validation.FileValidator;

import javax.swing.*;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class MainClass {
    public static final String INPUT_FILE_MESSAGE = "Type in path to file ... :";
    public static final String INPUT_KEY_MESSAGE = "Type the key ... :";
    public static final String ERROR_FILE_MESSAGE = "ERRROR : File you look for doesn't exists/is empty/dosent meet format";
    public static final String ERROR_KEY_MESSAGE = "ERROR : Entered key is beyond boundaries";
    public static final String ERROR_MENU_MESSAGE = "Not supprted action";

    public static void main(String[] args) throws IOException {
        MyCipher myCipher = new MyCipher();
        Scanner console = new Scanner(System.in);
        String inputFile;
        int key;
        while (true) {
            System.out.println("Choose an option" +
                    "\n 1 - Encrypt the file" +
                    "\n 2 - Decrytp the file" +
                    "\n 3 - Decrypt file via brute force attack" +
                    "\n 4 - Exit");

            int menu = Integer.parseInt(console.nextLine());
            switch (menu) {
                case 1:
                    System.out.println(INPUT_FILE_MESSAGE);
                    inputFile = console.nextLine();
                    System.out.println(INPUT_KEY_MESSAGE);
                    key = Integer.parseInt(console.nextLine());
                    break;
            }


        }
    }

    public static String keyValidator(int key) {
        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.checkKey(ERROR_KEY_MESSAGE, MyCipher.ALPHABET_LENGTH)) {
            System.out.println(ERROR_KEY_MESSAGE);
            return ERROR_KEY_MESSAGE;
        }
        return String.valueOf(Optional.ofNullable(fileValidator));


    }
}
