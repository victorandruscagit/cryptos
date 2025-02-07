package com.javarush.andrushka.canalyzer;

import com.javarush.andrushka.canalyzer.controllers.MainController;
import com.javarush.andrushka.canalyzer.entity.Result;
import com.javarush.andrushka.canalyzer.exceptions.AppException;

import java.util.Arrays;

public class Application {
    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }


    public Result run(String[] args) {
        //encode text.txt encode.txt 12
        if (args.length > 0) {
            String action = args[0]; //encode->action
            String[] parameters = Arrays.copyOfRange(args, 1, args.length); //parameters ->text.txt encode.txt 12
            mainController.doAction(action, parameters);
        }
        throw new AppException();
    }
}

