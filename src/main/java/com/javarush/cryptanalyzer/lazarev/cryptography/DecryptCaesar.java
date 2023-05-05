package com.javarush.cryptanalyzer.lazarev.cryptography;

import com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols;

import java.io.*;


public class DecryptCaesar {
    public static void decryptFile(String filePathIn, String filePathOut, int key) throws IOException {
        String alphabet = AlphabetAndSymbols.ALPHABET;
        File inFilePath = !filePathIn.equals("") ? new File(filePathIn) : new File("output.txt");
        File outFilePath = !filePathIn.equals("") ? new File(filePathOut) : new File("encoded.txt");


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFilePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(outFilePath))) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                StringBuilder outputLine = new StringBuilder();

                for (int i = 0; i < nextLine.length(); i++) {
                    char inputChar = nextLine.charAt(i);
                    int index = alphabet.indexOf(inputChar);
                    if (index == -1) {
                        outputLine.append(inputChar);
                    } else {
                        int outputIndex = (index + key + alphabet.length()) % alphabet.length();
                        outputLine.append(alphabet.charAt(outputIndex));
                    }
                }
                bufferedWriter.write(outputLine.toString());
                bufferedWriter.newLine();

            }
        }
    }
}