package com.example.NIO;

import java.io.IOException;
import java.nio.file.*;

/**
 *  파일 NIO를 이용한 디렉터리 목록 조회
 */
public class ListDirectory {
    public static void main(String[] args) {
        Path dir = Paths.get("/Users/jinwoopark/Desktop/git/practical-modern-java");

        // DirectoryStream을 이용한 처리
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }
}
