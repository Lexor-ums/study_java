package org.example;

import org.example.DictionaryRepository.ConsoleDictionaryRepository;
import org.example.DictionaryRepository.IDictionaryRepository;
import org.example.FileParsers.HtmlFileParser;
import org.example.FileParsers.IFileParser;
import org.example.NetDownloader.HttpFileDownloader;
import org.example.NetDownloader.IFileDownloader;

import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

/**
 * Hello world!
 */
class App {

    private static void parseUrl(String url) {
        CompletableFuture<Path> completableFuture = new CompletableFuture<>();
        downLoadSiteAsync(completableFuture, url);
        completableFuture.complete(null);
    }


    private static Map<String, Integer> parseFileAsync(Path path) {
        IFileParser parser = new HtmlFileParser();
        System.out.println("wait while downloading....");
        return parser.parse(path);
    }

    private static void storeToRepositoryAsync(String url, Map<String, Integer> dictionary) {
        if (dictionary.isEmpty())
            return;
        IDictionaryRepository store = new ConsoleDictionaryRepository();
        store.store(url, dictionary);
    }

    private static void downLoadSiteAsync(CompletableFuture<Path> future, String url) {
        IFileDownloader downloader = new HttpFileDownloader();
        future.thenApply(path -> downloader.downloadFile(url))
                .thenApplyAsync(path -> parseFileAsync(path))
                .thenAcceptAsync(dictionary -> storeToRepositoryAsync(url, dictionary))
                .exceptionally(throwable -> {
                    System.out.println(throwable.toString());
                    return null;
                });
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            String url;
            String quitString = "q";
            System.out.println("Please enter URL (e.g. https://google.com/) " +
                    "or enter \"q\" to exit");
            Scanner scan = new Scanner(System.in);
            url = scan.nextLine();

            while (!url.equalsIgnoreCase(quitString)) {
                parseUrl(url);
                System.out.println("Enter new URL or \"q\" to exit");
                url = scan.nextLine();
            }
        } else {
            for (String arg : args) {
                parseUrl(arg);
            }
        }
    }
}