package org.example.NetDownloader;

import java.io.IOException;
import java.nio.file.Path;

public interface IFileDownloader {

    /**
     * Загружает страницу по заданному адресу
     *
     * @param url адрес страницы
     */
    Path downloadFile(String url);
}
