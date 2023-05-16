package com.javarush.cryptanalyzer.lazarev.constants;

public class ApplicationConstant {
    public static final String SUCCESS = "Программа завершила работу c файлами успешно!";
    public static final String EXCEPTION = "Программа завершила работу с файлами ошибкой!";
    public static final String messageStart = """
                            Добро пожаловать в СУПЕРКРИПТОАНАЛИЗАТОР vol. 1.0
            Программа работает с текстовыми файлами, умеет зашифровывать и расшифровывать текст.
            """;

    public static final String messageIn =
            "Введите путь к исходному файлу или нажмите Enter, чтобы воспользоваться демонстрационным файлом :\n" +
            "(input.txt - используется для последующего  шифрования)";
    public static final String messageInBrut = "Введите путь к исходному файлу или нажмите Enter, чтобы воспользоваться демонстрационным файлом :\n" +
            "(encoded.txt - используется для последующей  расшифровки)";
    public static final String messageInDic = "Введите путь к файлу co словарём или нажмите Enter, чтобы воспользоваться демонстрационным файлом:\n" +
            "(dictionary.txt - будет использован в качестве словаря)";
    public static final String messageOut = "Введите путь к конечному файлу или нажмите Enter, чтобы воспользоваться демонстрационным файлом :\n" +
            "(В output.txt - сохраниться расшифрованный текст)";
    public static final String messageKeyMode = "Введите режим генерации ключа Enter для ручного ввода или \"r\" - для случайной генерации:";
    public static final String continueTyping = "Чтобы закончить редактирование введите - \"end\" или нажмите Enter, чтобы продолжить редактирование: ";

    public static final String messageKeyGenerated = "Сгенерирован ключ под номером: ";
    public static final String messageLetter = "Введите символ, который хотите заменить: ";
    public static final String messageLetterTwo = "Введите символ, НА который хотите заменить: ";

    public static final String messageKey = "Введите ключ в целочисленном диапазоне : ";
    public static final String messageCase = "Чтобы зашифровать файл для последующего статистического анализа, введите \"l\", или нажмите Enter, чтобы зашифровать файл обычным способом:";
    public static final String messageMode = """
            Выберете режим работы:\s
               Чтобы зашифровать текстовый файл, введите - "e"\s
               Чтобы расшифровать текстовый файл, введите - "d" \s
               Чтобы расшифровать текстовый файл методом BrutForce, введите - "b" (метод расшифровки перебором всех возможных ключей)
               Чтобы попытаться расшифровать текстовый файл методом StatisticalDecoder, введите - "s" (метод расшифровки на основе статистического анализа)
               Чтобы продолжить редактирование текстового файла вручную после работы метода StatisticalDecoder BETA_TEST!!! , введите "h"
               (возможно после применения метода StatisticalDecoder потребуется ручная перестановка некоторых символов):""";
    public static final String messageErrorEncode = "Операция кодирования завершилась ошибкой";
    public static final String messageErrorDecode = "Операция декодирования завершилась ошибкой";
    public static final String messageFalse = "Некорректный режим работы. Допустимые значения : \"e\" - для шифрования, " +
            "\"d\" - для расшифровки, \"b\" - Bruteforce, \"s\" - StaticalAnalyzer, \"s\" - SwapLetter !";

    public static final String messageValidKey = "Валидный ключ: ";

    public static final String NEW_FUNCTIONAL = "Функционал находится в стадии разработки";
    public static final String CONTINUE_PROGRAM = "Чтобы продолжить работать с программой нажмите \"y\" или нажмите \"n\" чтобы завершить выполнение программы";

}
