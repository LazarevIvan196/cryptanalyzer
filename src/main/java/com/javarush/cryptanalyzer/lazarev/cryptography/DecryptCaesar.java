package com.javarush.cryptanalyzer.lazarev.cryptography;

import com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols;

import java.io.*;


public class DecryptCaesar {
    public static void decryptFile(String filePathIn, String filePathOut, int key) throws IOException {
        String alphabet = AlphabetAndSymbols.ALPHABET;

        File inFilePath = filePathIn.isEmpty() ? new File("encoded.txt") : new File(filePathIn);
        File outFilePath = filePathOut.isEmpty() ? new File("output.txt") : new File(filePathOut);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFilePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFilePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder outputLine = new StringBuilder();

                for (char c : line.toCharArray()) {
                    int index = alphabet.indexOf(c);
                    if (index == -1) {
                        outputLine.append(c);
                    } else {
                        int outputIndex = (index + key) % alphabet.length();
                        outputLine.append(alphabet.charAt(outputIndex));
                    }
                }
                bufferedWriter.write(outputLine.toString());
                bufferedWriter.newLine();
            }
        }
    }
}