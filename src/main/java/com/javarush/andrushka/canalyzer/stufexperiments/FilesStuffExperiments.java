package com.javarush.andrushka.canalyzer.stufexperiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FilesStuffExperiments {
    private static final String HOME = System.getProperty("user.home");
    public static void main(String[] args) throws IOException {

       createFile();

    }

    private static  void createFile() throws IOException {
        String  fileName = "myFile_"  + UUID.randomUUID().toString() +  ".txt";
        String  dirName = "MyDir_" + UUID.randomUUID().toString() ;
        Path pathFile = Paths.get(HOME + "/" + fileName);
        Path pathDirectory = Paths.get(HOME + "/" + dirName);

        Path file = Files.createFile(pathFile);
        Path directory = Files.createDirectory(pathDirectory);

        System.out.println(file);
        System.out.println(file.toFile().isFile());
        System.out.println(directory);
        System.out.println(directory.toFile().isDirectory());

    }
}
