package com.example.NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesCheckerExample {
    // 파일의 상태와 권한을 확인하는 예
    public static void main(String[] args) {
        if (args.length < 1) {
            printUsage();
            return;
        }

        Path path = Paths.get(args[0]);

        // Path 정보가 실제로 존재하는지 여부 확인
        if (Files.exists(path) && !Files.notExists(path)) {
            System.out.println("Path가 존재합니다.");
        } else {
            System.out.println("Path가 존재하지 않거나 문제가 있습니다.");
        }

        // 파일과 디렉터리 구분
        if (Files.isDirectory(path)) {
            System.out.println("디렉터리");
        } else {
            System.out.println("파일");
        }

        // 파일 권한 확인
        if (Files.isReadable(path)) {
            System.out.println("읽기 가능");
        }

        if(Files.isWritable(path)) {
            System.out.println("쓰기 가능");
        }

        if(Files.isExecutable(path)) {
            System.out.println("실행 가능");
        }

        // 일반 파일인지 확인
        System.out.println("Reqular Files : " + Files.isRegularFile(path));
    }

    private static void printUsage() {
        System.out.println("java FilesChecker <path information>");
        System.out.println("<path information> : file or directory path");
    }
}
