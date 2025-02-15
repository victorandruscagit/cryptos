package com.javarush.andrushka.canalyzer.zashita.mains;

import com.javarush.andrushka.canalyzer.zashita.cipher.MyCipher;
import com.javarush.andrushka.canalyzer.zashita.validation.FileValidator;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;
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
                    "\n 2 - Decrypt the file" +
                    "\n 3 - Decrypt  the file via brute force attack" +
                    "\n 4 - Exit");

            try {
                int menu = Integer.parseInt(console.nextLine());
                switch (menu) {
                    case 1:
                        System.out.println(INPUT_FILE_MESSAGE);
                        inputFile = console.nextLine();
                        System.out.println(INPUT_KEY_MESSAGE);
                        key = Integer.parseInt(console.nextLine());
                        if (Objects.isNull(keyValidator(key))
                                && Objects.isNull(fileValidator(inputFile))) {
                            myCipher.encrypt(inputFile, key);
                        }
                        return;
                    case 2:
                        System.out.println(INPUT_FILE_MESSAGE);
                        inputFile = console.nextLine();
                        System.out.println(INPUT_KEY_MESSAGE);
                        key = Integer.parseInt(console.nextLine());
                        if (Objects.isNull(keyValidator(key))
                                && Objects.isNull(fileValidator(inputFile))) {
                            myCipher.decrypt(inputFile, key);
                        }
                        return;
                    case 3:
                        System.out.println(INPUT_FILE_MESSAGE);
                        inputFile = console.nextLine();
                        if (fileValidator(inputFile) == null) {
                            myCipher.bruteForce(inputFile);
                        }
                        return;
                    case 4:
                        console.close();
                        return;
                    default:
                        System.out.println(ERROR_MENU_MESSAGE);
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(ERROR_MENU_MESSAGE);
            }


        }
    }

    public static String fileValidator(String inputFile) {
        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.rightExtensionCheck(inputFile)
        || !fileValidator.checkIfFileExists(inputFile)
        || !fileValidator.checkIfFileIsEmpty(inputFile)) {
            System.out.println(ERROR_FILE_MESSAGE);
            return ERROR_FILE_MESSAGE;
        }
        return String.valueOf(Optional.ofNullable(ERROR_FILE_MESSAGE));


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
