package com.example.time;

import java.time.YearMonth;

/**
 * YearMonth를 이용한 월 정보 처리 예쩨
 * @author jinwoopark
 */
public class YearMonthExample {
    public static void main(String[] args) {
        // 현재 기준으로 생성
        YearMonth date = YearMonth.now();
        System.out.println(date + " : " + date.lengthOfMonth());

        // 1년 추가
        YearMonth date2 = date.plusYears(1);
        System.out.println(date2 + " : " + date2.lengthOfMonth());

        // 1개월 추가
        YearMonth date3 = date.plusMonths(1);
        System.out.println(date3 + " : " + date3.lengthOfMonth());
    }
}
