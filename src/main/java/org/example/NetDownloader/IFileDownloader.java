package org.example.NetDownloader;

import java.io.IOException;
import java.nio.file.Path;

public interface IFileDownloader {

    /**
     * Downloads web page with given URL and saves it to disk
     * in the downloads folder
     *
     * @param url a URL of desired web-page
     */
    Path downloadFile(String url);
}
