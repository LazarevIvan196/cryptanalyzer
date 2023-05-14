package com.javarush.cryptanalyzer.lazarev.view;

import com.javarush.cryptanalyzer.lazarev.entity.Result;

import java.util.Scanner;

import static com.javarush.cryptanalyzer.lazarev.constants.ApplicationConstant.*;
import static com.javarush.cryptanalyzer.lazarev.constants.FunctionCodeConstants.*;


public class ConsoleView implements View {
    @Override
    public String[] getParameters() {
        String[] parameters = new String[6];
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(messageStart);
            System.out.print(messageMode);
            parameters[0] = scanner.nextLine();
            switch (parameters[0].toLowerCase()) {
                case DECRYPT -> getDecryptParams(scanner, parameters);
                case ENCRYPT -> getEncryptParams(scanner, parameters);
                case BRUT -> getBrutParams(scanner, parameters);
                case STAT -> getStatParams(scanner, parameters);
                case SWAP -> getSwapParams(scanner, parameters);
            }
            return parameters;
        }
    }

    private void getDecryptParams(Scanner scanner, String[] parameters) {
        System.out.println(messageKey);
        parameters[1] = scanner.nextLine();
        System.out.println(messageIn);
        parameters[2] = scanner.nextLine();
        System.out.println(messageOut);
        parameters[3] = scanner.nextLine();
    }

    private void getEncryptParams(Scanner scanner, String[] parameters) {
        System.out.println(messageIn);
        parameters[1] = scanner.nextLine();
        System.out.println(messageOut);
        parameters[2] = scanner.nextLine();
        System.out.println(messageKeyMode);
        parameters[3] = scanner.nextLine();
        if (parameters[3].equalsIgnoreCase(MANUAL)) {
            System.out.println(messageKey);
            parameters[4] = scanner.nextLine();
        }
        System.out.println(messageCase);
        parameters[5] = scanner.nextLine();
    }

    private void getBrutParams(Scanner scanner, String[] parameters) {
        System.out.println(messageIn);
        parameters[1] = scanner.nextLine();
        System.out.println(messageOut);
        parameters[2] = scanner.nextLine();
        System.out.println();
    }

    private void getStatParams(Scanner scanner, String[] parameters) {
        System.out.println(messageIn);
        parameters[1] = scanner.nextLine();
        System.out.println(messageOut);
        parameters[2] = scanner.nextLine();
        System.out.println(messageInDic);
        parameters[3] = scanner.nextLine();

    }


    private void getSwapParams(Scanner scanner, String[] parameters) {
        System.out.println(messageIn);
        parameters[1] = scanner.nextLine();
        System.out.println(continueTyping);
        while (scanner.hasNextLine()) {
            parameters[2] = scanner.nextLine();
            if (parameters[2].equals("")) {
                System.out.println(messageLetter);
                parameters[3] = scanner.nextLine();
                System.out.println(messageLetterTwo);
                parameters[4] = scanner.nextLine();
                System.out.println(continueTyping);
            } else if (parameters[2].equalsIgnoreCase(END)) {
                parameters[3] = " ";
                parameters[4] = " ";
                break;
            }
        }
        scanner.close();
    }

    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }

    }
}
