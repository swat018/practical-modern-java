package com.example.Stream;

import com.example.functional_programming.TravelInfoDAO;
import com.example.functional_programming.TravelInfo;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilterExample {
    // Stream 인터페이스의 filter 사용 예
    public static void main(String[] args) {
        List<TravelInfo> travelList = TravelInfoDAO.createTravelList();
        Stream<TravelInfo> travelStream = travelList.stream();

        // 필터 조건을 정의한다.
//        travelStream.filter(new Predicate<TravelInfo>() {
//            @Override
//            public boolean test(TravelInfo t) {
//                return TravelInfoDAO.COUNTRY_PHILLIPHINE.equals(t.getCountry());
//            }
//        }).forEach(System.out::println);

        travelStream.filter((TravelInfo t) -> TravelInfoDAO.COUNTRY_PHILLIPHINE.equals(t.getCountry()))
                .forEach(System.out::println);

    }
}
