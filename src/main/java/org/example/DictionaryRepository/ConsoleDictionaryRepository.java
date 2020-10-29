package org.example.DictionaryRepository;

import java.util.Map;

public class ConsoleDictionaryRepository implements IDictionaryRepository {

    /**
     * Вывродит сожержимое словаря в консорль
     *
     * @param source     адрес сохранёной страницы
     * @param dictionary словарь, содержащий слова и частоту их
     *                  нахождения на странице
     */
    @Override
    public void store(String source, Map<String, Integer> dictionary) {
        System.out.println("Data from " + source + ":");
        for (Map.Entry<String, Integer> item : dictionary.entrySet()) {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
    }
}
