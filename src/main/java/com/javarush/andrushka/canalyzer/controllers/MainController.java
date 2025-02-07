package com.javarush.andrushka.canalyzer.controllers;

import com.javarush.andrushka.canalyzer.commands.Action;
import com.javarush.andrushka.canalyzer.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        //action > encode
        // parameters ->[text.txt,  encode.txt,  12]
        Action action = Actions.find(actionName);
        Result result = action.exectute(parameters);
        return result;


    }
}
