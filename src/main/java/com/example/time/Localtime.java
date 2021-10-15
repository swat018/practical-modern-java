package com.example.time;

import java.time.LocalTime;

/**
 * LocalTime 사용 예제
 * @author jinwoopark
 */
public class Localtime {
    public static void main(String[] args) {
        // 현재 기준으로 시간 정보를 생성한다.
        LocalTime localTime = LocalTime.now();
        System.out.println("현재 시간 : " + localTime);

        // 시간 추가
        System.out.println("시 추가 : " + localTime.plusHours(1));
        System.out.println("분 추가 : " + localTime.plusMinutes(15));
        System.out.println("초 추가 : " + localTime.plusSeconds(30));
        System.out.println("나노 추가 : " + localTime.plusNanos(50000));

        // 시간 제거
        System.out.println("시 제거 : " + localTime.minusHours(1));
        System.out.println("분 제거 : " + localTime.minusMinutes(15));
        System.out.println("초 제거 : " + localTime.minusSeconds(30));
        System.out.println("나노 제거 : " + localTime.minusNanos(50000));
    }
}