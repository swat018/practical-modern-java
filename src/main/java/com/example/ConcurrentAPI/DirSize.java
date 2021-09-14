package com.example.ConcurrentAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DirSize {
    // 재귀 호출되는 메서드
    protected Long compute(Path path) {
        long fileSize = 0;

        try {
            List<Path> fileList = Files.list(path).collect(Collectors.toList());

            for(Path file : fileList) {
                if(Files.isDirectory(file)) {
                    fileSize += compute(file);
                } else {
                    fileSize += Files.size(file);
                }
            }
        } catch(IOException e) {
            System.out.println("Error : " + path);
        }
        return fileSize;
    }

    // 재귀 호출로 처리하는 예
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Path rootPath = Paths.get("/Users/jinwoopark/Downloads");

        DirSize dirSize = new DirSize();
        System.out.printf("합계 : %s\n", dirSize.compute(rootPath));

        long endTime  = System.currentTimeMillis();

        System.out.print("처리 시간 : " + (endTime - startTime));
    }
}
