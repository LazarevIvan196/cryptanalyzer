package com.javarush.cryptanalyzer.lazarev.function;

import com.javarush.cryptanalyzer.lazarev.entity.Result;
import com.javarush.cryptanalyzer.lazarev.exception.ApplicationException;
import com.javarush.cryptanalyzer.lazarev.repository.ResultCode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols.ALPHABET_FOR_STATICAL;
import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.messageErrorDecode;
import static com.javarush.cryptanalyzer.lazarev.constants.FunctionCodeConstants.*;
import static com.javarush.cryptanalyzer.lazarev.repository.ResultCode.ERROR;

public class StatisticalDecoder implements Function {


    @Override
    public Result execute(String[] parameters) {
        String alphabet = ALPHABET_FOR_STATICAL;

        File inFilePath = parameters[1].isEmpty() ? new File(ENCODED) : new File(parameters[1]);
        File outFilePath = parameters[2].isEmpty() ? new File(OUTPUT) : new File(parameters[2]);
        File dicFilePath = parameters[3].isEmpty() ? new File(DICTIONARY) : new File(parameters[3]);

        HashMap<Character, Double> sampleStats = new HashMap<>();
        try (BufferedReader sampleReader = new BufferedReader(new FileReader(dicFilePath))) {
            String line;
            double totalChars = 0;
            while ((line = sampleReader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (alphabet.indexOf(c) != -1) {
                        totalChars++;
                        sampleStats.put(c, sampleStats.getOrDefault(c, 0.0) + 1.0);
                    }
                }
            }
            for (char c : sampleStats.keySet()) {
                sampleStats.put(c, sampleStats.get(c) / totalChars);
            }

        } catch (IOException e) {
            return new Result(ERROR, new ApplicationException(messageErrorDecode));
        }
        HashMap<Character, Double> encodedStats = new HashMap<>();
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inFilePath))) {
            String line;
            double totalChars = 0;
            while ((line = inputReader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (alphabet.indexOf(c) != -1) {
                        totalChars++;
                        encodedStats.put(c, encodedStats.getOrDefault(c, 0.0) + 1.0);
                    }
                }
            }

            for (char c : encodedStats.keySet()) {
                encodedStats.put(c, encodedStats.get(c) / totalChars);
            }

        } catch (IOException e) {
            return new Result(ERROR, new ApplicationException(messageErrorDecode));
        }

        HashMap<Character, Character> charMap = new HashMap<>();
        ArrayList<Character> encodedChars = new ArrayList<>(encodedStats.keySet());
        ArrayList<Character> sampleChars = new ArrayList<>(sampleStats.keySet());
        for (char c : encodedChars) {
            double bestMatchScore = Double.MAX_VALUE;
            char bestMatchChar = '?';
            for (char d : sampleChars) {
                double matchScore = Math.abs(encodedStats.get(c) - sampleStats.get(d));
                if (matchScore < bestMatchScore && !charMap.containsValue(d)) {
                    bestMatchScore = matchScore;
                    bestMatchChar = d;
                }
            }
            charMap.put(c, bestMatchChar);
        }

        try (BufferedReader inputReader = new BufferedReader(new FileReader(inFilePath));
             BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outFilePath))) {
            String line;
            while ((line = inputReader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (alphabet.indexOf(c) != -1) {
                        outputWriter.write(charMap.getOrDefault(c, c));
                    } else {
                        outputWriter.write(c);
                    }
                }

                outputWriter.newLine();
            }

        } catch (IOException e) {
            return new Result(ERROR, new ApplicationException(messageErrorDecode));
        }
        return new Result(ResultCode.OK);
    }
}