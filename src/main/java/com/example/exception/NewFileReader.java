package com.example.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * try with resource 구문을 이용한 파일 처리 예쩨
 * @author jinwoopark
 */
public class NewFileReader {
    private static final String FILENAME = "/Users/jinwoopark/Desktop/git/practical-modern-java/test/filename.txt";

    public static void main(String[] args) {
        // try 문장의 resource 절에서 Reader를 생성하였다.
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
