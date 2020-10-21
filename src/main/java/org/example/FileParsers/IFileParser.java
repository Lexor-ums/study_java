package org.example.FileParsers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface IFileParser {

    /**
     * Parses given HTML-file and creates dictionary containing
     * readable words and number of their occurrence
     *
     * @param path a path to the HTML-file
     */
    Map<String, Integer> parse(Path path);
}
