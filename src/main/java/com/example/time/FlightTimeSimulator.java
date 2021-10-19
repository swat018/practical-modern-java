package com.example.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * ZonedDateTime을 이용해서 시차 기반의 날자 시간 계산하는 예정
 * @author jinwoopark
 */
public class FlightTimeSimulator {
    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

        // 서울발 로스엔젤레스 국제 공항(LAX)행 출발
        LocalDateTime leaving = LocalDateTime.of(2018, Month.MAY, 9, 17, 20);
        ZoneId leavingZone = ZoneId.of("Asia/Seoul");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        try {
            String out1 = departure.format(format);
            System.out.printf("출발 : %s (%s)%n", out1, leavingZone);

        } catch (DateTimeException e) {
            throw e;
        }

        // 12시간 후 LAX 도착
        ZoneId arrivingzZone = ZoneId.of("America/Los_Angeles");
        // 현지 기준 도착 시간 계산
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingzZone).plusMinutes(720);

        try {
            String out2 = arrival.format(format);
            System.out.printf("도착 : %s (%s)%n", out2, arrivingzZone);
        } catch (DateTimeException e) {
            throw e;
        }

        // 서머타임 적용 여부 확인
        if (arrivingzZone.getRules().isDaylightSavings(arrival.toInstant())) {
            System.out.printf(" (%s 서머타임 시간 적용.)%n", arrivingzZone);
        } else {
            System.out.printf(" (%s 표준 시간 작용.)%n", arrivingzZone);
        }
    }
}
