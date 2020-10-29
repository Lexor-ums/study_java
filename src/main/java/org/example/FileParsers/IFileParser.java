package org.example.FileParsers;

import java.nio.file.Path;
import java.util.Map;

public interface IFileParser {

    /**
     * Разбирает сохранённую страницу и создаёт словарь, сождержащий слова
     * и частоту нахождения
     *
     * @param path путь к странице
     * @return словарь, сождержащий слова и частоту нахождения
     */
    Map<String, Long> parse(Path path);
}
