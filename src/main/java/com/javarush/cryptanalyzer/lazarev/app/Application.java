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
            case ENCRYPT -> FunctionCode.valueOf(ENCODE).getFunction();
            case DECRYPT -> FunctionCode.valueOf(DECODE).getFunction();
            case BRUT -> FunctionCode.valueOf(BRUTEFORCE).getFunction();
            case STAT -> FunctionCode.valueOf(STATISTICAL).getFunction();
            case SWAP ->FunctionCode.valueOf(SWAP_LETTER).getFunction();
            case default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();
        };
    }
    public void printResult(Result result){
        mainController.getView().printResult(result);
    }
}
