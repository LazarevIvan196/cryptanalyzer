package com.javarush.cryptanalyzer.lazarev.function;

import com.javarush.cryptanalyzer.lazarev.entity.Result;
import com.javarush.cryptanalyzer.lazarev.exception.ApplicationException;
import com.javarush.cryptanalyzer.lazarev.repository.ResultCode;

import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.messageFalse;

public class UnsupportedFunction implements Function {
    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.ERROR, new ApplicationException(messageFalse));
    }
}
