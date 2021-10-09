package com.example.NIO;

import java.io.IOException;
import java.nio.file.*;

/**
 *  DirectoryStream.Filter를 이용한 파일 필터링 예
 */
public class NewFileFilter2 {
    public static void main(String[] args) {
        Path dir = Paths.get("/Users/jinwoopark/Desktop/git/practical-modern-java");

        // 필터를 정의한다.
        DirectoryStream.Filter<Path> filter = file -> (Files.isDirectory(file));

        // DirectoryStream.Filter를 기준으로 목록을 조회한다.
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, filter)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.err.println(e);
        }
    }
}
