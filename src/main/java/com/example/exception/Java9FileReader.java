package com.example.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Java 9 이상이어야 컴파일된다.
 * @author jinwoopark
 */
public class Java9FileReader {
    private static final String FILENAME = "/Users/jinwoopark/Desktop/git/practical-modern-java/test/filename.txt";

    public static void main(String[] args) throws Exception {
        // 외부에서 생성하였다.
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));

        // resource 구문 안에 변수를 지정하였다.
        try(br) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
