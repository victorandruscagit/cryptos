package com.javarush.andrushka.canalyzer.controllers;

import com.javarush.andrushka.canalyzer.commands.Action;
import com.javarush.andrushka.canalyzer.commands.Decoder;
import com.javarush.andrushka.canalyzer.commands.Encoder;
import com.javarush.andrushka.canalyzer.exceptions.AppException;

public enum Actions {
    ENCODE(new Encoder()),

    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String actionName) {
        try {
            Actions values = Actions.valueOf(actionName.toUpperCase());
            return values.action;
        } catch (IllegalArgumentException e) {
            throw new AppException();
        }
    }
}
