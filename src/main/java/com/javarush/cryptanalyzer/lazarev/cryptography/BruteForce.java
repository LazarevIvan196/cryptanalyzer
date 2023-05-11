package com.javarush.cryptanalyzer.lazarev.cryptography;
import com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols;
import com.javarush.cryptanalyzer.lazarev.constants.UserMessage;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BruteForce {
    public static void brutForceFile(String filePathIn, String filePathOut) throws IOException {
        String alphabet = AlphabetAndSymbols.ALPHABET;
        File inFilePath = filePathIn.isEmpty() ? new File("encoded.txt") : new File(filePathIn);
        File outFilePath = filePathOut.isEmpty() ? new File("output.txt") : new File(filePathOut);

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

                if (outputText.toString().matches("^[а-яёА-ЯЁ \\Q.\\E,\\-;\"\\s!:?]+$")) {
                    bufferedWriter.write(outputText.toString());
                    bufferedWriter.newLine();
                    System.out.println(UserMessage.messageDecrypt);
                    System.out.printf(UserMessage.messageValidKey, key);
                }
            }
        }
    }
}





