package org.example.NetDownloader;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class HttpFileDownloader implements IFileDownloader {

    /**
     * Загружает страницу по заданному адресу
     *
     * @param url адрес страницы
     */
    @Override
    public Path downloadFile(String url) {
        Path path = Paths.get(Paths.get("").toAbsolutePath().toString().concat("/downloads/"));
        try {
            Files.createDirectories(path);
            URL resource = new URL(url);
            InputStream stream = resource.openStream();
            Path downloadsFile = Paths.get(path.toString().concat("/").concat(resource.getHost()).concat(".html"));
            Files.copy(stream, downloadsFile, REPLACE_EXISTING);
            return downloadsFile;
        } catch (Throwable exception) {
            throw new RuntimeException(exception.toString());
        }

    }
}