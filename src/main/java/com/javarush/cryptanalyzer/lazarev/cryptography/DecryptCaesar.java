package com.javarush.cryptanalyzer.lazarev.cryptography;

import com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols;

import java.io.*;
import java.util.Scanner;

public class DecryptCaesar {
    public static void decryptFile(String filePathIn, String filePathOut, int key) throws IOException {
        File inFilePath = new File(filePathIn);
        File outFilePath = new File(filePathOut);
        Scanner scanner = new Scanner(inFilePath);
        PrintWriter writer = new PrintWriter(outFilePath);
        String alphabet = AlphabetAndSymbols.ALPHABET;
        int alphabetLength = alphabet.length();

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            StringBuilder outputLine = new StringBuilder();

            for (int i = 0; i < inputLine.length(); i++) {
                char inputChar = inputLine.charAt(i);
                int index = alphabet.indexOf(inputChar);
                if (index == -1) {
                    continue;
                } else {
                    int outputIndex = (index - key + alphabet.length()) % alphabet.length();
                    outputLine.append(alphabet.charAt(outputIndex));
                }
            }

            writer.println(outputLine.toString());
        }

        writer.close();
        scanner.close();
    }

}
