package com.javarush.andrushka.canalyzer.commands;

import com.javarush.andrushka.canalyzer.entity.Result;
import com.javarush.andrushka.canalyzer.entity.ResultCode;

public class Decoder implements Action{
    @Override
    public Result exectute(String[] parameters) {

        return new Result("decode all right", ResultCode.OK);
    }
}
