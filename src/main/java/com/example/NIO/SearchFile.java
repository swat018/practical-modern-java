package com.example.NIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/**
 *  PathMatcher를 이용한 파일 검색 예쩨
 */
public class SearchFile {
    // SimpleFileVisitor를 상속한 내부 클래스 정의
    public static class FilesFinder extends SimpleFileVisitor<Path> {
        // 패턴을 정의하는 객체
        private final PathMatcher matcher;

        FilesFinder(String pattern) {
            // 파일을 필터링할 패턴을 정의한다.
            matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        }

        // 원하는 패턴과 일치하는지 확인한다.
        public boolean isMatched(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            isMatched(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            isMatched(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
            e.printStackTrace();
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Path startingDir = Paths.get("/Users/jinwoopark/Desktop/git/practical-modern-java");

        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        FilesFinder filesFinder = new FilesFinder("g*.{java,bat}");
        Files.walkFileTree(startingDir, opts, Integer.MAX_VALUE, filesFinder);
    }
}
