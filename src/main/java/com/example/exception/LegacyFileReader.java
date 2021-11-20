package com.example.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 파일을 읽어서 표준 출력 화면에 내용을 표시하는 예제
 * @author jinwoopark
 */
public class LegacyFileReader {
    private static final String FILENAME = "/Users/jinwoopark/Desktop/git/practical-modern-java/test/filename.txt";

    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            // Reader 객체를 생성한다.
            br = new BufferedReader(new FileReader(FILENAME));

            String sCurrentLine;

            // 한 줄씩 읽어서 출력한다.
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) try { br.close(); } catch(IOException e) {}
        }
    }
}
