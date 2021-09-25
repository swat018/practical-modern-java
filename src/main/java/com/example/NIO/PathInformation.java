package com.example.NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInformation {
    // Path 인터페이스를 이용한 경로 정보 출력 예
    public static void main(String[] args) {
        Path path = Paths.get("/Users/jinwoopark/Desktop/git");

        System.out.format("toString: %s\n", path.toString());
        System.out.format("getFileName: %s\n", path.getFileName());
        System.out.format("getName(0): %s\n", path.getName(0));
        System.out.format("getNameCount: %s\n", path.getNameCount());
        System.out.format("subpath(0,2): %s\n", path.subpath(0,2));
        System.out.format("getParent: %s\n", path.getParent());
        System.out.format("getRoot: %s\n", path.getRoot());
    }
}
