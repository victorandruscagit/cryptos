package com.javarush.andrushka.canalyzer.zashita.validation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileValidator {
    public boolean checkIfFileExists(String inputFile) {
        return Files.exists(Path.of(inputFile));
    }

    public boolean checkIfFileIsEmpty(String inputFile) {
        File file = Path.of(inputFile).toFile();
        return file.length() == 0 ? false : true;
    }

    public boolean rightExtensionCheck(String file) {
        String txtPart = file.substring(file.lastIndexOf(".") + 1, file.length());
        return Objects.equals(txtPart, "txt") ? true : false;
    }

    public boolean checkKey(Integer key, int maxValue) {
         return (key > 0) && (key < maxValue);

    }
}
