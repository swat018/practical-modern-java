package com.example.NIO;


import java.io.*;

/**
 * JAVA 6까지 파일을 읽고 쓰던 방법이다.
 * File 객체와 BufferedReader, BufferedWriter를 이용하였다.
 *
 */
public class OldFileCopy {
    public static void copyFile(File sourceFile, File targetFile) {
        // 파일이 존재하고, 디렉터리가 아닌 파일인지 확인한다.
        if(sourceFile.exists() && sourceFile.isFile()) {
            try(BufferedReader br = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
                System.out.println("## 파일 복사 시작 ##");

                char[] buffer = new char[1024];
                int readCount = 0;

                while((readCount = br.read(buffer)) > 0) {
                    bw.write(buffer, 0, readCount);
                }
                System.out.println("## 파일 복사 완료 ##");
            }catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("파일을 복사할 수 없습니다.");
        }
    }

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Usage : java OldFileCopy <source file> <target files>");
            return;
        }

        // 복사할 파일
        File sourceFile = new File(args[0]);
        // 대상 파일
        File targetFile = new File(args[1]);

        copyFile(sourceFile, targetFile);
    }
}
