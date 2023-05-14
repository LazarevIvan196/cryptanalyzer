package com.javarush.cryptanalyzer.lazarev.view;

import com.javarush.cryptanalyzer.lazarev.entity.Result;

import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.NEW_FUNCTIONAL;

public class GUIView implements View{

    @Override
    public String[] getParameters() {
        return new String[0];
    }

    @Override
    public void printResult(Result result) {
        System.out.println(NEW_FUNCTIONAL);
    }
}
