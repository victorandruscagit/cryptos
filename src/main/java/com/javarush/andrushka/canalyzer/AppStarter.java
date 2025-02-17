package com.javarush.andrushka.canalyzer;


import com.javarush.andrushka.canalyzer.validator.InputValidator;
import com.javarush.andrushka.canalyzer.zashita.cipher.MyCipher;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AppStarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator inputValidator = new InputValidator();
        MyCipher caesarCipher = new MyCipher();
        while (true) {
            System.out.println("/n Select an optoin :");
            System.out.println("1 Encrypt  text :");
            System.out.println("2 Decrypt text :");
            System.out.print("3 Brute for force decrypt :");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\nType file's path");
                    String fileToEncrypt = scanner.nextLine();
                    System.out.println("Type encryption key....");
                    int key = Integer.parseInt(scanner.nextLine());
                    try {
                        if (inputValidator.isFileExists(fileToEncrypt) && inputValidator.isKeyValid(key)) {
                            caesarCipher.encrypt(fileToEncrypt, key);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:


                    break;

                case 3:


                    break;
                case 4:
                    return;

                default:
                    System.out.println("Did not make a choice");

            }
        }


    }


}
