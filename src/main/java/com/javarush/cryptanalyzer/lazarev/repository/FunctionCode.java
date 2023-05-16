package com.javarush.cryptanalyzer.lazarev.repository;


import com.javarush.cryptanalyzer.lazarev.function.*;


public enum FunctionCode {
    ENCODE(new Encode()),
    DECODE(new Decode()),
    BRUTEFORCE(new BruteForce()),
    STATISTICAL(new StatisticalDecoder()),
    UNSUPPORTED_FUNCTION(new UnsupportedFunction()),
    SWAP_LETTER(new SwapLetters()),
    CONTINUE(new Continue()),
    CLOSE(new Close());
    private final Function function;

    FunctionCode(Function function) {

        this.function = function;
    }

    public Function getFunction() {

        return function;
    }
}
