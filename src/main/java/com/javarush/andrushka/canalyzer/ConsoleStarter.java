package com.javarush.andrushka.canalyzer;

import com.javarush.andrushka.canalyzer.entity.Result;

import java.util.Arrays;

public class ConsoleStarter {
    public static void main(String[] args) {

        Application application = new Application();
        Result run = application.run(args);
        System.out.println(run);


    }
}
