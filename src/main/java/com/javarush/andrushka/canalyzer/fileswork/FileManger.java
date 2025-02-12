package com.javarush.andrushka.canalyzer.fileswork;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class FileManger {


    public String readFile(String filePath) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Provide a path");
            String currentDirectory = scanner.nextLine();
            while (true) {
                System.out.printf("%s:%n", currentDirectory);
                System.out.println("1.Files and directories ...");
                int userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice) {
                    case 1:
                        listDirAndFiles(currentDirectory);
                        break;


                }

            }
        }


    }

    private static void listDirAndFiles(String currentDirectory) throws IOException {
        File directory = Files.createDirectory(Paths.get(currentDirectory)).toFile();

        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file != null) {
                    BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    System.out.printf("File name,  %s, created at %s, with  %dMB size and with  folowing access rights : %s",
                            file.getName(),
                            basicFileAttributes.creationTime().toString(),
                            basicFileAttributes.size(),
                            (file.canRead()? "r" : "-") + (file.canWrite()? "w" : "-")
                            );

                }
            }
        }


    }

    public void writeFile(String content, String filePath) {


    }
}
