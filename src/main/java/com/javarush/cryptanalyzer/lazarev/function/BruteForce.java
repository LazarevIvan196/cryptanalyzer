package com.javarush.cryptanalyzer.lazarev.function;

import com.javarush.cryptanalyzer.lazarev.entity.Result;
import com.javarush.cryptanalyzer.lazarev.exception.ApplicationException;
import com.javarush.cryptanalyzer.lazarev.repository.ResultCode;

import java.io.*;

import static com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols.ALPHABET;
import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.messageErrorDecode;
import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.messageValidKey;
import static com.javarush.cryptanalyzer.lazarev.constants.FunctionCodeConstants.*;
import static com.javarush.cryptanalyzer.lazarev.repository.ResultCode.ERROR;


public class BruteForce implements Function {

    @Override
    public Result execute(String[] parameters) {

        String alphabet = ALPHABET;
        File inFilePath = parameters[1].isEmpty() ? new File(ENCODED) : new File(parameters[1]);
        File outFilePath = parameters[2].isEmpty() ? new File(OUTPUT) : new File(parameters[2]);

        String validKey = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFilePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFilePath))) {
            StringBuilder inputText = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputText.append(line).append("\n");
            }

            for (int key = 1; key < alphabet.length(); key++) {
                StringBuilder outputText = new StringBuilder();

                for (int i = 0; i < inputText.length(); i++) {
                    char inputChar = inputText.charAt(i);
                    int index = alphabet.indexOf(inputChar);
                    if (index == -1) {
                        outputText.append(inputChar);
                    } else {
                        int outputIndex = (index + key) % alphabet.length();
                        outputText.append(alphabet.charAt(outputIndex));
                    }
                }

                if (outputText.toString().matches(REGEX)) {
                    bufferedWriter.write(outputText.toString());
                    bufferedWriter.newLine();
                    validKey = String.valueOf(key);
                }
            }
        } catch (IOException e) {
            return new Result(ERROR, new ApplicationException(messageErrorDecode));
        }
        System.out.println(messageValidKey + validKey);
        return new Result(ResultCode.OK);
    }
}






