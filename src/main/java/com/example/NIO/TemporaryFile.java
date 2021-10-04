package com.example.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *  파일 NIO을 이용한 임시 파일 처리 에
 */
public class TemporaryFile {
    public static void main(String[] args) {
        try {
            // 임시 디렉터리 생성
            Path tempDirectory = Files.createTempDirectory("java11");
            System.out.format("임시 디렉터리 : %s%n", tempDirectory);

            // 임시 파일 생성
            Path tempFile = Files.createTempFile(tempDirectory, null, ".tempdata");
            System.out.format("임시 파일 : %s%n", tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
