package com.javarush.andrushka.canalyzer.fileswork;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManger {
    public String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return  new String(bytes, StandardCharsets.UTF_8);
    }

    public void writeFile(String content, String filePath){

    }
}
