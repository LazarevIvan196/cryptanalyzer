package com.javarush.cryptanalyzer.lazarev.function;

import com.javarush.cryptanalyzer.lazarev.entity.Result;
import com.javarush.cryptanalyzer.lazarev.exception.ApplicationException;
import com.javarush.cryptanalyzer.lazarev.repository.ResultCode;

import java.io.*;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols.ALPHABET;
import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.messageErrorDecode;
import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.messageKey;
import static com.javarush.cryptanalyzer.lazarev.constants.FunctionCodeConstants.ENCODED;
import static com.javarush.cryptanalyzer.lazarev.constants.FunctionCodeConstants.OUTPUT;
import static com.javarush.cryptanalyzer.lazarev.repository.ResultCode.ERROR;


public class Decode implements Function {


    @Override
    public Result execute(String[] parameters) {
        String alphabet = ALPHABET;
        File inFilePath = parameters[2].isEmpty() ? new File(ENCODED) : new File(parameters[2]);
        File outFilePath = parameters[3].isEmpty() ? new File(OUTPUT) : new File(parameters[3]);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFilePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFilePath))) {
            int key = Integer.parseInt(parameters[1]);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder outputLine = new StringBuilder();

                for (char c : line.toCharArray()) {
                    int index = alphabet.indexOf(c);
                    if (index == -1) {
                        outputLine.append(c);
                    } else {
                        int outputIndex = (index + key % 83) % alphabet.length();
                        outputLine.append(alphabet.charAt(outputIndex));
                    }
                }
                bufferedWriter.write(outputLine.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            return new Result(ERROR, new ApplicationException(messageErrorDecode));
        }
        return new Result(ResultCode.OK);
    }
}