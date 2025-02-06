package com.javarush.andrushka.canalyzer;

import java.util.Arrays;

public class ConsoleStarter {
    public static void main(String[] args) {


        /*int key = 111;
        String text = "Just a text";
        String result = "";*/

        System.out.println(Arrays.toString(args));
        Application result = new Application(args);
        result.run();

    }
}
