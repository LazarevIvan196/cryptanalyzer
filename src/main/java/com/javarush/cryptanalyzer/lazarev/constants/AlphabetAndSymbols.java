package com.javarush.cryptanalyzer.lazarev.constants;

public class AlphabetAndSymbols {
    private static final String alphabetUpperCase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    private static final String alphabetLowerCase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    private static final String numbers = "0123456789";
    private static final String symbols = ".,\":-!? ";
    public static final String ALPHABET = alphabetLowerCase + alphabetUpperCase + numbers + symbols;

}
