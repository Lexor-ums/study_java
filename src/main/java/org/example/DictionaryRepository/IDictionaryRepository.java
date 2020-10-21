package org.example.DictionaryRepository;

import java.util.Map;

public interface IDictionaryRepository {

    /**
     * Outputs data containing in the dictionary to console
     *
     * @param source     an URL of page the dictionary was generated from
     * @param dictionary the dictionary containing words and
     *                   number of occurrences of each word
     */
    void store(String source, Map<String, Integer> dictionary);
}
