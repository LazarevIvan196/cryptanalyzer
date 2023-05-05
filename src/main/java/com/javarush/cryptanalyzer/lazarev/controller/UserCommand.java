package com.javarush.cryptanalyzer.lazarev.controller;

import com.javarush.cryptanalyzer.lazarev.cryptography.DecryptCaesar;
import com.javarush.cryptanalyzer.lazarev.cryptography.EncryptCaesar;

import java.io.IOException;
import java.util.Scanner;

public class UserCommand {
    final String messageIn = "Введите путь к исходному файлу: ";
    final String messageOut = "Введите путь к конечному файлу: ";
    final String messageKey = "Введите ключ в целочисленном диапазоне от 1 до 83: ";
    final String messageMode = "Введите режим работы \"e\" = \"encrypt\" или \"d\" = \"decrypt\": ";
    final String messageEncrypt = "Файл успешно зашифрован и сохранен в директорию к исходному файлу!";
    final String messageDecrypt = "Файл успешно расшифрован и сохранен в директорию к исходному файлу";
    final String messageFalse = "Некорректный режим работы. Допустимые значения: \"e\" = \"encrypt\" \\ \"d\" = \"decrypt\"! ";


    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(messageIn);
        String filePathIn = scanner.nextLine();
        System.out.print(messageOut);
        String filePathOut = scanner.nextLine();

        System.out.print(messageKey);
        int key = scanner.nextInt();
        System.out.print(messageMode);
        scanner.nextLine();
        String mode = scanner.nextLine();
        if (mode.equalsIgnoreCase("e")) {
            try {
                EncryptCaesar.encryptFile(filePathIn, filePathOut, key);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(messageEncrypt);
        } else if (mode.equalsIgnoreCase("d")) {
            try {
                DecryptCaesar.decryptFile(filePathIn, filePathOut, key);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(messageDecrypt);
        } else {
            System.out.println(messageFalse);
        }
    }


}
