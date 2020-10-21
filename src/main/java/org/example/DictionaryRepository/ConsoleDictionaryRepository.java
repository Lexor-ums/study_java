package org.example.DictionaryRepository;

import java.util.Map;

public class ConsoleDictionaryRepository implements IDictionaryRepository {

    @Override
    public void store(String source, Map<String, Integer> dictionary) {
        System.out.println("Data from " + source + ":");
        for (Map.Entry<String, Integer> item : dictionary.entrySet()) {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
    }
}
