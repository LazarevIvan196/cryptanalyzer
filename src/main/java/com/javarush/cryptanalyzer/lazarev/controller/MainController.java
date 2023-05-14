package com.javarush.cryptanalyzer.lazarev.controller;

import com.javarush.cryptanalyzer.lazarev.view.View;

public class MainController {

    private View view;

    public MainController(View view) {
        this.view = view;
    }
public View getView(){
        return view;
}
}
