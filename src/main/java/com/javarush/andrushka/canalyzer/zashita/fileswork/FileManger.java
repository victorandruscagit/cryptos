package com.javarush.andrushka.canalyzer.zashita.fileswork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;

public class FileManger {

    public void writeFile(List<String> contentLines, String outputFilePath) {
        try {
            Files.write(Path.of(outputFilePath), contentLines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readFileLines( String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
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
