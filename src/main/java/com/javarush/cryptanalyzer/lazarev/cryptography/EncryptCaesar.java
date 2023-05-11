package com.javarush.cryptanalyzer.lazarev.cryptography;

import com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols;

import java.io.*;


public class EncryptCaesar {

    public static void encryptFile(String filePathIn, String filePathOut, int key) throws IOException {
        String alphabet = AlphabetAndSymbols.ALPHABET;

        File inFilePath = filePathIn.isEmpty() ? new File("input.txt") : new File(filePathIn);
        File outFilePath = filePathOut.isEmpty() ? new File("encoded.txt") : new File(filePathOut);

        try (BufferedReader reader = new BufferedReader(new FileReader(inFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outFilePath))) {
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
                writer.write(encryptedLine.toString());
                writer.newLine();
            }
        }
    }
}

