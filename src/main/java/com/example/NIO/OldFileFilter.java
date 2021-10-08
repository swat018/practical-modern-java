package com.example.NIO;

import java.io.File;
import java.io.FilenameFilter;

/**
 *  자바 7까지 사용하던 파일 필터링을 위한 예
 */
public class OldFileFilter {
    public static void main(String[] args) {
        File file = new File("/Users/jinwoopark/Desktop/git/practical-modern-java");
        // FilenameFilter 인터페이스를 구현해서 필터링한다.
        // 람다 표현식으로 변경할 수 있다.
//        String[] filteredFile = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                System.out.println(dir + File.separator + name);
//                return name.toLowerCase().endsWith(".md");
//            }
//        });
//
//        for (String fileName : filteredFile) {
//            System.out.println(fileName);
//        }

        // 람다 표현식을 이용한 FilenameFilter 구현
        String[] filteredFile = file.list((File dir, String name) -> name.toLowerCase().endsWith(".md"));

        for (String fileName : filteredFile) {
            System.out.println(fileName);
        }

    }
}
