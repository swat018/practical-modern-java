package com.example.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjuster 인터페이스를 구현해서 기능을 확장하는 예제
 * @author jinwoopark
 */
public class CustomTemporalAdjuster implements TemporalAdjuster {
    public static int TRANSFER_DATE = 25;

    // adjustInfo 메서드를 구현한다.
    @Override
    public Temporal adjustInto(Temporal inputValue) {
        // 입력된 값의 날짜 객체를 생성
        LocalDate currentDate = LocalDate.from(inputValue);
        // 입력된 값의 날짜 객체를 기준으로 이체해야 할 날짜를 구함
        LocalDate transferDate = currentDate.withDayOfMonth(TRANSFER_DATE);

        // 만일 오늘 일자가 TRANSFER_DATE보다 클 경우 다음 달에 이체를 하도록 설정
        if (currentDate.getDayOfMonth() > TRANSFER_DATE) {
            transferDate = transferDate.plusMonths(1);
        }

        // 이체해야 하는 일자가 토요일 혹은 일요일일 경우 월요일로 이체 일자 조정
        if (transferDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                transferDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            transferDate = transferDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }

        // 결과 전달
        return inputValue.with(transferDate);
    }

    public static void main(String[] args) {
        CustomTemporalAdjuster adjuster = new CustomTemporalAdjuster();
        // 2018.07.15 기준 이체 일자
        System.out.printf("2108.07.15 기준 이체 일자 : %s%n", adjuster.adjustInto(LocalDate.of(2018,7,15)));
        // 2018.08.21 기준 이체 일자
        System.out.printf("2018.08.21 기준 이체 일자 : %s%n", adjuster.adjustInto(LocalDate.of(2018,8,21)));
    }
}
