package com.javarush.andrushka.canalyzer.validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {


    public boolean isFileExists(String filePath) throws IOException {
        Path path = Path.of(filePath);
        File file = new File(String.valueOf(path));
        if (file.isFile() || file.exists()) {
            System.out.println("file doesnt exists");
            return false;
        }
        return  true;

    }

    public  boolean isKeyValid(int key){
        return false;
    }
}
