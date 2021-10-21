package com.example.time;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * TemporalAdjuster 인터페이스를 구현해서 기능을 확장하는 예제
 * @author jinwoopark
 */
public class CustomTemporalAdjuster implements TemporalAdjuster {
    public static int TRANSFER_DATE = 25;

    // adjustInfo 메서드를 구현한다.
    @Override
    public Temporal adjustInto(Temporal temporal) {
        // 입력된 값의 날짜 객체를 생성


        return null;
    }
}
