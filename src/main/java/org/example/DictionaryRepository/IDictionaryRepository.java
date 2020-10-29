package org.example.DictionaryRepository;

import java.util.Map;

public interface IDictionaryRepository {

    /**
     * Вывродит сожержимое словаря в консорль
     *  @param source     адрес сохранёной страницы
     * @param dictionary словарь, содержащий слова и частоту их
     */
    void store(String source, Map<String, Long> dictionary);
}
