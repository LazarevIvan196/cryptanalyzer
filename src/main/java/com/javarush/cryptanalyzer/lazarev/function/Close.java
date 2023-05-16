package com.javarush.cryptanalyzer.lazarev.function;

import com.javarush.cryptanalyzer.lazarev.entity.Result;

public class Close implements Function{
    @Override
    public Result execute(String[] parameters) {
        System.exit(0);
        return null;
    }
}
