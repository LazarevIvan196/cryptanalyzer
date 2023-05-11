package com.javarush.cryptanalyzer.lazarev;


import com.javarush.cryptanalyzer.lazarev.app.Application;
import com.javarush.cryptanalyzer.lazarev.controller.MainController;
import com.javarush.cryptanalyzer.lazarev.entity.Result;
import com.javarush.cryptanalyzer.lazarev.view.ConsoleView;
import com.javarush.cryptanalyzer.lazarev.view.View;

public class EntryPoint {
    public static void main(String[] args) {
        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.start();
        application.printResult(result);
    }
}



