package com.javarush.cryptanalyzer.lazarev.function;

import com.javarush.cryptanalyzer.lazarev.entity.Result;
import com.javarush.cryptanalyzer.lazarev.exception.ApplicationException;
import com.javarush.cryptanalyzer.lazarev.repository.ResultCode;

import java.io.*;

import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.messageErrorDecode;
import static com.javarush.cryptanalyzer.lazarev.constants.FunctionCodeConstants.OUTPUT;
import static com.javarush.cryptanalyzer.lazarev.repository.ResultCode.ERROR;

public class SwapLetters extends StatisticalDecoder implements Function {

    @Override
    public Result execute(String[] parameters) {
        File file = parameters[1].isEmpty() ? new File(OUTPUT) : new File(parameters[1]);
        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {


            char letterOne = parameters[3].charAt(0);
            char letterTwo = parameters[4].charAt(0);
            char temp = 'W';

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == letterOne) {
                    text.setCharAt(i, temp);
                }
            }

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == letterTwo) {
                    text.setCharAt(i, letterOne);
                }
            }

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == temp) {
                    text.setCharAt(i, letterTwo);
                }
            }

            try {
                writer.write(text.toString());
                writer.flush();

            } catch (IOException e) {
                return new Result(ERROR, new ApplicationException(messageErrorDecode));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Result(ResultCode.OK);
    }
}