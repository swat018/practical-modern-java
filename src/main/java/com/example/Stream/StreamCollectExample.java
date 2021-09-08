package com.example.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("장윤기", 45));
        personList.add(new Person("장해라", 18));
        personList.add(new Person("장해윤", 14));
        personList.add(new Person("장윤기", 45));

        // 최종 결과물 List 객체로 리턴한다.
        List<Person> sortedList = personList.stream().sorted().collect(Collectors.toList());

        for(Person person : sortedList) {
            System.out.println(person);
        }
    }
}
