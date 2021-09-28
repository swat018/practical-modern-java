package com.example.NIO;

import java.io.IOException;
import java.nio.file.*;

/**
 * JAVA 7에 파일을 복사하는 예제이다.
 * Files 클래스를 사용하였다.
 *
 */
public class NewFilesCopy {
    public static void copyFile(Path source, Path target, CopyOption[] options) {
        if(Files.isDirectory(source) || Files.notExists(source)) {
            System.out.println("소스 파일이 존재하지 않거나 디렉토리 입니다.");
            return;
        }
        try {
            if(Files.exists(target)) {
                System.out.println("대상 파일이 존재합니다.");
            }

            // 파일을 복사한다.
            Files.copy(source, target, options);
        } catch(FileAlreadyExistsException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Usage : java NewFilesCopy <source file> <target file>");
            return;
        }

        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);

        CopyOption[] options = {StandardCopyOption.REPLACE_EXISTING};

        copyFile(source, target, options);
    }
}
