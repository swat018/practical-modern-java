package com.example.time;

import java.time.*;
import java.time.temporal.Temporal;

/**
 * Temporal을 이용해서 날짜와 시간을 변경하는 예쩨
 * @author jinwoopark
 */
public class LocalDateTimeAdjusters {
    public static void main(String[] args) {
        // 1. 동일형의 변환
        LocalDateTime beforeDate = LocalDateTime.of(2018, Month.APRIL, 10, 8, 40);
        LocalDateTime afterDate = LocalDateTime.now();

        // afterDate를 beforeDate 값으로 변환해서 리턴한다.
        Temporal temporalDate = beforeDate.adjustInto(afterDate);

        System.out.printf("Before Date : %s%n", beforeDate);
        System.out.printf("After Date : %s%n", afterDate);
        System.out.printf("Temporal Date : %s%n", temporalDate);
        System.out.printf("Before Date : %s%n", beforeDate);
        System.out.printf("After Date : %s%n", afterDate);

        // 2. 다른 형의 변환
        LocalDate localDate = LocalDate.of(2018, Month.APRIL, 10);
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Los_Angeles"));
        Temporal temporalObject = localDate.adjustInto(zdt);

        if(temporalObject instanceof LocalDate) {
            System.out.println("temporalObject is LocalDate");
        }

        if(temporalObject instanceof ZonedDateTime) {
            System.out.println("temporalObject is ZonedDateTime");
        }
    }
}
