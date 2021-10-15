package com.example.time;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * LocalDateTime을 이용한 날짜 시간 처리 예제
 * @author jinwoopark
 */
public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.printf("현재 : %s%n", localDateTime);

        System.out.printf("생일 : %s%n", LocalDateTime.of(1984, Month.MAY, 18, 16, 33));

        // 날짜 이후, 이전
        System.out.printf("1달 후 : %s%n", localDateTime.plusMonths(6));
        System.out.printf("1딜 잔 : %s%n", localDateTime.minusMinutes(6));
    }
}
