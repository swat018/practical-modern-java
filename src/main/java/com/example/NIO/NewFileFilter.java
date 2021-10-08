package com.example.NIO;

import java.io.IOException;
import java.nio.file.*;

/**
 *  파일 NIO에서 파일 필터링을 구현한 예
 */
public class NewFileFilter {
    public static void main(String[] args) {
        Path dir = Paths.get("/Users/jinwoopark/Desktop/git/practical-modern-java");

        // 문자 표현식을 이용해서 필터링한다.
         try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.md")) {
             for (Path file: stream) {
                 System.out.println(file.getFileName());
             }
         } catch(IOException | DirectoryIteratorException e) {
             e.printStackTrace();
         }
    }
}
