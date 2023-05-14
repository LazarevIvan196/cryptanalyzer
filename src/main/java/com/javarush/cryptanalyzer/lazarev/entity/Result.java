package com.javarush.cryptanalyzer.lazarev.entity;

import com.javarush.cryptanalyzer.lazarev.exception.ApplicationException;
import com.javarush.cryptanalyzer.lazarev.repository.ResultCode;

public class Result {
    private ResultCode resultCode;
    private ApplicationException applicationException;


    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public Result(ResultCode resultCode, ApplicationException applicationException) {
        this.resultCode = resultCode;
        this.applicationException = applicationException;
    }

    public ResultCode getResultCode() {
        return resultCode;

    }

    public ApplicationException getApplicationException() {
        return applicationException;
    }
}
