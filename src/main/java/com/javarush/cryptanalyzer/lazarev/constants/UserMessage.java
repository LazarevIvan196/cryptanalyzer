package com.javarush.cryptanalyzer.lazarev.constants;

public class UserMessage {

    public static final String messageStart = """
                            Добро пожаловать в СУПЕРКРИПТОАНАЛИЗАТОР vol. 1.0
            Программа работает с текстовыми файлами,умеет зашифровывать и расшифровывать текст.
            """;

    public  static final String messageIn = "Введите путь к исходному файлу, или нажмите \"Enter\", чтобы воспользоваться демонстрационным файлом: ";
    public  static final String messageOut = "Введите путь к конечному файлу, или нажмите \"Enter\", чтобы воспользоваться демонстрационным файлом: ";
    public  static final String messageKeyMode = "Введите режим генерации ключа \"m\" = \"manual\" \\ \"r\" = \"random\": ";
    public  static final String messageKeyInsert = "Введен ключ под номером: %d\n";
    public  static final String messageKeyGenerated = "Сгенерирован ключ под номером: %d\n";

    public  static final String messageKey = "Введите ключ в целочисленном диапазоне от 1 до 83: ";
    public  static final String messageMode = "Введите режим работы \"e\" = \"encrypt\" \\ \"d\" = \"decrypt\" \\ \"b\" = \"brutforce\":  ";
    public  static final String messageEncrypt = "Файл успешно зашифрован и сохранен в директорию к исходному файлу!";
    public  static final String messageDecrypt = "Файл успешно расшифрован и сохранен в директорию к исходному файлу";
    public  static final String messageFalse = "Некорректный режим работы. Допустимые значения: \"e\" = \"encrypt\" \\ \"d\" = \"decrypt\"! ";
    public  static final String messageFalseKey = "Некорректный режим работы. Допустимые значения: \"m\" = \"manual\"  или \"r\" = \"random\"! ";
    public  static final String messageValidKey = "Валидный ключ: %d\n ";
    public  static final String messageNoValidKey = "Валидный ключ не найден ";
    public  static final String messageDecryptFailed = "Программа не смогла расшифровать переданный текст";

}
