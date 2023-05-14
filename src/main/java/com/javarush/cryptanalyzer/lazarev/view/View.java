package com.javarush.cryptanalyzer.lazarev.view;

import com.javarush.cryptanalyzer.lazarev.entity.Result;

public interface View {
    String[] getParameters();


    void printResult(Result result);
}
