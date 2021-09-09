package com.example.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayToStreamExample {
    // 배열을 스트림으로 변환하는 예
    public static void main(String[] args) {
        Person[] personList
                = { new Person("장윤기", 45),
                    new Person("장해라", 18),
                    new Person("장해윤", 14),
                    new Person("장윤기", 45) };

        Stream<Person> stream = Arrays.stream(personList);
        stream.forEach(System.out::println);
    }
}
