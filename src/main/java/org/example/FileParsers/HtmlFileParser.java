package org.example.FileParsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class HtmlFileParser implements IFileParser {

    /**
     * Разбирает сохранённую страницу и создаёт словарь, сождержащий слова
     * и частоту нахождения
     *
     * @param path путь к странице
     */
    @Override
    public Map<String, Integer> parse(Path path){
        File file = new File(path.toString());
        Map<String, Integer> dictionary = new HashMap<>();

        long allocatedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        long presumableFreeMemory = Runtime.getRuntime().maxMemory() - allocatedMemory;

        if (file.length() < presumableFreeMemory) {

            Document doc = null;
            try {
                doc = Jsoup.parse(file, "utf8");
                String text = doc.text();

                String[] words = text.split("[ ,.!?\";:()\n\r\t[]][]]]");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        if (!dictionary.containsKey(word)) {
                            dictionary.put(word, 1);
                        } else {
                            dictionary.replace(word, dictionary.get(word) + 1);
                        }
                    }
                }
            } catch (IOException exception) {
                throw new RuntimeException();
            }
        }
        return dictionary;
    }
}
