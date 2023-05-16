package com.javarush.cryptanalyzer.lazarev.function;

import com.javarush.cryptanalyzer.lazarev.entity.Result;
import com.javarush.cryptanalyzer.lazarev.exception.ApplicationException;
import com.javarush.cryptanalyzer.lazarev.repository.ResultCode;

import java.io.*;

import static com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols.ALPHABET;
import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.*;
import static com.javarush.cryptanalyzer.lazarev.constants.FunctionCodeConstants.*;
import static com.javarush.cryptanalyzer.lazarev.repository.ResultCode.ERROR;

public class Encode implements Function {

    @Override
    public Result execute(String[] parameters) {
        String alphabet = ALPHABET;
        File inFilePath = parameters[1].isEmpty() ? new File(INPUT) : new File(parameters[1]);
        File outFilePath = parameters[2].isEmpty() ? new File(ENCODED) : new File(parameters[2]);

        try (BufferedReader reader = new BufferedReader(new FileReader(inFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outFilePath))) {
            int key = 0;
            if (parameters[3].equalsIgnoreCase("")) {
                key = Integer.parseInt(parameters[4]);
                key = key % 83;
            } else if (parameters[3].equalsIgnoreCase(RANDOM)) {
                key = (int) (Math.random() * alphabet.length());
                key = key % 83;
                System.out.println(messageKeyGenerated + key);

            }

            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder encryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    int index = alphabet.indexOf(c);
                    if (index == -1) {
                        encryptedLine.append(c);
                    } else {
                        int newIndex = (index - key + alphabet.length()) % alphabet.length();
                        encryptedLine.append(alphabet.charAt(newIndex));
                    }
                }
                if (parameters[5].equalsIgnoreCase("")) {
                    writer.write(encryptedLine.toString());

                } else if (parameters[5].equalsIgnoreCase(LOWERCASE)) {
                    writer.write(encryptedLine.toString().toLowerCase());
                }
                writer.newLine();
            }

        } catch (IOException e) {
            return new Result(ERROR, new ApplicationException(messageErrorEncode));
        }
        return new Result(ResultCode.OK);
    }
}

