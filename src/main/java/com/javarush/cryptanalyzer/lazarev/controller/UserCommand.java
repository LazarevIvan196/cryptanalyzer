package com.javarush.cryptanalyzer.lazarev.controller;

import com.javarush.cryptanalyzer.lazarev.constants.AlphabetAndSymbols;
import com.javarush.cryptanalyzer.lazarev.cryptography.BruteForce;
import com.javarush.cryptanalyzer.lazarev.cryptography.DecryptCaesar;
import com.javarush.cryptanalyzer.lazarev.cryptography.EncryptCaesar;
import com.javarush.cryptanalyzer.lazarev.constants.UserMessage;

import java.io.IOException;
import java.util.Scanner;


public class UserCommand {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(UserMessage.messageStart);
        System.out.print(UserMessage.messageMode);
        String mode = scanner.nextLine();

        if (mode.equalsIgnoreCase("e")) {
            encryptMode(scanner);
        } else if (mode.equalsIgnoreCase("d")) {
            decryptMode(scanner);
        } else if (mode.equalsIgnoreCase("b")) {
            bruteForceMode(scanner);
        } else {
            System.out.println(UserMessage.messageFalse);
        }
        scanner.close();
    }
    private void encryptMode(Scanner scanner) {
        System.out.print(UserMessage.messageIn);
        String filePathIn = scanner.nextLine();
        System.out.print(UserMessage.messageOut);
        String filePathOut = scanner.nextLine();
        int key = 0;
        System.out.print(UserMessage.messageKeyMode);
        String keyMode = scanner.nextLine();
        if (keyMode.equalsIgnoreCase("m")) {
            key = getManualKey(scanner);
        } else if (keyMode.equalsIgnoreCase("r")) {
            key = getRandomKey();
            System.out.printf(UserMessage.messageKeyGenerated, key);
        } else {
            System.out.println(UserMessage.messageFalseKey);
        }

        try {
            EncryptCaesar.encryptFile(filePathIn, filePathOut, key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(UserMessage.messageEncrypt);
    }
    private void decryptMode(Scanner scanner) {
        System.out.print(UserMessage.messageIn);
        String filePathIn = scanner.nextLine();
        System.out.print(UserMessage.messageOut);
        String filePathOut = scanner.nextLine();
        int key = getManualKey(scanner);
        try {
            DecryptCaesar.decryptFile(filePathIn, filePathOut, key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(UserMessage.messageDecrypt);
    }
    private void bruteForceMode(Scanner scanner) {
        System.out.print(UserMessage.messageIn);
        String filePathIn = scanner.nextLine();
        System.out.print(UserMessage.messageOut);
        String filePathOut = scanner.nextLine();
        try {
            BruteForce.brutForceFile(filePathIn, filePathOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private int getManualKey(Scanner scanner) {
        System.out.print(UserMessage.messageKey);
        int key = scanner.nextInt();
        System.out.printf(UserMessage.messageKeyInsert, key);
        scanner.nextLine();
        return key;
    }
    private int getRandomKey() {
        return (int) (Math.random() * AlphabetAndSymbols.ALPHABET.length());

    }
}



