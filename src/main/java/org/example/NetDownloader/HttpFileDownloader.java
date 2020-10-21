package org.example.NetDownloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class HttpFileDownloader implements IFileDownloader {

    /**
     * Downloads web page with given URL and saves it to disk
     * in the downloads folder
     *
     * @param url a URL of desired web-page
     */
    @Override
    public Path downloadFile(String url){
        Path currentRelativePath = Paths.get("");
        String m_path = currentRelativePath.toAbsolutePath().toString();
        String m_folder = "/downloads/";
        m_path = m_path.concat(m_folder);
        Path path = Paths.get(m_path);

        Path downloadsFolder = null;
        Path downloadsFile = null;
        try {
            downloadsFolder = Files.createDirectories(path);
            URL resource = null;
            resource = new URL(url);
            InputStream stream = null;
            stream = resource.openStream();
            downloadsFile = Paths.get(downloadsFolder.toString().concat("/").concat(resource.getHost()).concat(".html"));
            Files.copy(stream, downloadsFile, REPLACE_EXISTING);
            return downloadsFile;
        } catch (Throwable exception) {
            throw new RuntimeException();
        }

    }
}
