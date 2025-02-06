package com.javarush.andrushka.canalyzer;

import com.javarush.andrushka.canalyzer.controllers.MainController;
import com.javarush.andrushka.canalyzer.entity.Result;

import java.util.Arrays;

public class Application {
    private MainController mainController;

    public Application() {
        mainController.doAction()
        mainController = new MainController();

    }

    public Result run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            mainController.doAction(action, parameters);
        }
        return null;
    }
}
