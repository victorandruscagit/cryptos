package com.javarush.andrushka.canalyzer.fileswork;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FileManger {


    public  static  String readFile(String filePath) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Provide a path");
            String currentDirectory = scanner.nextLine();
            while (true) {
                int userChoice = Integer.parseInt(scanner.nextLine());
                System.out.printf("1 -> Files and directories ...  %s:%n", currentDirectory);
                System.out.printf("2 -> Find by name   %s:%n", currentDirectory);
                System.out.print("2 -> Copy   ");
                userChoice(userChoice, currentDirectory, scanner);

            }
        }


    }

    public static void userChoice(int userChoice, String currentDirectory, Scanner scanner) throws IOException {
        switch (userChoice) {
            case 1:
                listDirAndFiles(currentDirectory);
                break;
            case 2:
                System.out.print("Type looked up name : ...");
                String byName = scanner.nextLine();
                searchByName(currentDirectory, byName);
                break;
            case 3:
                System.out.println("Type source file....");
                String sourceFile = scanner.nextLine();
                System.out.println("Type destination file....");
                String destFile = scanner.nextLine();
                copyOp(sourceFile, destFile);
                break;
            case 4:
                System.out.println("Sort type. 1 - By name . 2 - By lenght");
                int sortType = Integer.parseInt(scanner.nextLine());
                sortFiles(currentDirectory, sortType);
        }
    }

    public static void sortFiles(String currentDirectory, int sortType) {
        File directory = Path.of(currentDirectory).toFile();
        for (File file : directory.listFiles()) {
            List<File> fileList = Arrays.asList(file);
            switch (sortType) {
                case 1:
                    Collections.sort(fileList, Comparator.comparing(File::getName));
                    break;
                case 2:
                    Collections.sort(fileList, Comparator.comparingLong(File::length));
                    break;
                default:
                    System.out.println("");


            }
        }
    }

    private static void copyOp(String sourceFile, String destFile) {
        Path source = Path.of(sourceFile);
        Path destination = Path.of(destFile);

        if (Files.isDirectory(source)) {
            try {
                Files.walk(source)
                        .forEach(pfile -> {
                            Path resolve = destination.resolve(pfile.relativize(pfile));
                        });
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private static void searchByName(String currentDirectory, String byName) {
        try {
            File directory = Files.createDirectory(Paths.get(currentDirectory)).toFile();
            if (directory != null) {
                for (File file : directory.listFiles()) {
                    if (file.getName().contains(byName)) {
                        System.out.printf("Found : %s  ", file.getAbsolutePath());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void listDirAndFiles(String currentDirectory) throws IOException {
        File directory = Files.createDirectory(Paths.get(currentDirectory)).toFile();

        try {
            if (directory.isDirectory()) {
                for (File file : directory.listFiles()) {
                    if (file != null) {
                        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                        System.out.printf("File name,  %s, created at %s, with  %dMB size and with  folowing access rights : %s",
                                file.getName(),
                                basicFileAttributes.creationTime().toString(),
                                basicFileAttributes.size(),
                                (file.canRead() ? "r" : "-") + (file.canWrite() ? "w" : "-")
                        );

                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getCause());
        }


    }

    public void writeFile(String content, String filePath) {


    }
}
