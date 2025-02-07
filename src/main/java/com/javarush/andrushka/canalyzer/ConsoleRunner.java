package com.javarush.andrushka.canalyzer;

import com.javarush.andrushka.canalyzer.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        //encode text.txt encode.txt 12

        Application application = new Application();
        Result run = application.run(args);
        System.out.println(run);


    }
}
