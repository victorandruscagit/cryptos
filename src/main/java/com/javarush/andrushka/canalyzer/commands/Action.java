package com.javarush.andrushka.canalyzer.commands;

import com.javarush.andrushka.canalyzer.entity.Result;

public interface Action {
    Result exectute(String [] parameters );
}
