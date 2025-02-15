package com.javarush.andrushka.canalyzer.fileswork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;

public class FileManger {


    public String readFile(String filePath) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Provide a path");
            String currentDirectory = scanner.nextLine();
            while (true) {
                int userChoice = Integer.parseInt(scanner.nextLine());
                System.out.printf("1 -> Files and directories ...  %s:%n", currentDirectory);
                System.out.printf("2 -> Find by name   %s:%n", currentDirectory);
                System.out.print("2 -> Copy   ");
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


                }

            }
        }


    }

    private static void copyOp(String sourceFile, String destFile) {

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

    private static void listDirAndFiles(String currentDirectory) throws IOException {
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

    public void writeFile(List<String> contentLines, String outputFilePath) {
        try {
            Files.write(Path.of(outputFilePath), contentLines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public List<String> readFileLines(String content, String filePath) {

        try {
            return Files.readAllLines(Path.of(content));
        } catch (IOException e) {
            System.out.println("Wasn't able to read file");
            throw new RuntimeException(e);
        }


    }

    public String entireFilePath(String inputFile, int key) {
        String inputFileDir = Path.of(inputFile).getParent().toString();
        String outputFile = inputFile.substring(inputFile.lastIndexOf('/'),inputFile.lastIndexOf('.')) + key +".txt";
        return String.join(inputFileDir, outputFile);


    }


}
