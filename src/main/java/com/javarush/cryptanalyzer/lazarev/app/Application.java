package com.javarush.cryptanalyzer.lazarev.app;

import com.javarush.cryptanalyzer.lazarev.controller.MainController;
import com.javarush.cryptanalyzer.lazarev.entity.Result;
import com.javarush.cryptanalyzer.lazarev.function.Function;
import com.javarush.cryptanalyzer.lazarev.repository.FunctionCode;

import static com.javarush.cryptanalyzer.lazarev.constants.FunctionCodeConstants.*;


public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result start() {
        String[] parameters = mainController.getView().getParameters();
        String mode = parameters[0];
        Function function = getFunction(mode);
        return function.execute(parameters);
    }

    private Function getFunction(String mode) {
        return switch (mode) {
            case ENCRYPT -> FunctionCode.ENCODE.getFunction();
            case DECRYPT -> FunctionCode.DECODE.getFunction();
            case BRUT -> FunctionCode.BRUTEFORCE.getFunction();
            case STAT -> FunctionCode.STATISTICAL.getFunction();
            case SWAP -> FunctionCode.SWAP_LETTER.getFunction();
            default -> FunctionCode.UNSUPPORTED_FUNCTION.getFunction();
        };
    }

    public void printResult(Result result) {
        mainController.getView().printResult(result);
    }
}
