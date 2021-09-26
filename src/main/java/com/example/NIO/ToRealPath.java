package com.example.NIO;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToRealPath {
    // toRealPath 사용 예
    public static void main(String[] args) {
        try {
            // 심볼릭 링크를 실제 경로로 전환해서 객체 생성
            Path path = Paths.get("/Users/jinwoopark/git").toRealPath();
            print(path);

            // 심볼릭 링크 경로로 객체 생성
//            path = Paths.get("/Users/jinwoopark/git");
            path = Paths.get("/Users/jinwoopark/git").toRealPath(LinkOption.NOFOLLOW_LINKS);
            print(path);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Path 객체의 정보를 출력한다.
    private static void print(Path path) {
        System.out.format("toString: %s\n", path.toString());
        System.out.format("getFileName: %s\n", path.getFileName());
        System.out.format("getName(0): %s\n", path.getName(0));
        System.out.format("getNameCount: %s\n", path.getNameCount());
        System.out.format("subpath(0,2): %s\n", path.subpath(0,2));
        System.out.format("getParent: %s\n", path.getParent());
        System.out.format("getRoot: %s\n", path.getRoot());
    }
}
