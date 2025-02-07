package com.javarush.andrushka.canalyzer.commands;

import com.javarush.andrushka.canalyzer.entity.Result;
import com.javarush.andrushka.canalyzer.entity.ResultCode;

public class Encoder implements Action{
    @Override
    public Result exectute(String[] parameters) {

        return new Result("encode all right", ResultCode.OK);
    }
}
