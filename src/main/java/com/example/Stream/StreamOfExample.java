package com.example.Stream;

import java.util.stream.Stream;

public class StreamOfExample {
    // of 메서드로 스트림 객체 생성하는 예
    public static void main(String[] args) {
        Stream<Person> stream = Stream.of(new Person("장윤기", 45),
                new Person("장해라", 18),
                new Person("장해윤", 14),
                new Person("장윤기", 45));
        stream.forEach(System.out::println);
    }
}
