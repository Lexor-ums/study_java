package org.example.FileParsers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface IFileParser {

    /**
     * Разбирает сохранённую страницу и создаёт словарь, сождержащий слова
     * и частоту нахождения
     *
     * @param path путь к странице
     */
    Map<String, Integer> parse(Path path);
}
