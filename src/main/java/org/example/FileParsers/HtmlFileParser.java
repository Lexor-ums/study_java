package org.example.FileParsers;

import org.jsoup.Jsoup;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HtmlFileParser implements IFileParser {

    /**
     * Разбирает сохранённую страницу и создаёт словарь, сождержащий слова
     * и частоту нахождения
     *
     * @param path путь к странице
     * @return  словарь, сождержащий слова и частоту нахождения
     */
    @Override
    public Map<String, Long> parse(Path path) {
        try {
            FileInputStream inputStream = new FileInputStream(path.toString());
            return Arrays.stream(Jsoup.parse(inputStream, "utf8", "")
                    .text()
                    .split("[ ,.!?\";:()\n\r\t[]][]]]")).filter(s -> !s.isEmpty())
                    .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }
}
