package com.example.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMapExample {

    // 스트림 map 메서드 사용 예
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("장윤기", 45));
        personList.add(new Person("장해라", 18));
        personList.add(new Person("장해윤", 14));
        personList.add(new Person("장윤기", 45));

        // Stream<Person> -> Stream<String>으로 변환한다.
        Stream<String> personStream = personList.stream().map((Person p) -> p.toString());
        personStream.forEach(System.out::println);
    }
}
