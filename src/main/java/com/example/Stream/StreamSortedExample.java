package com.example.Stream;

import java.util.ArrayList;
import java.util.List;

// 실행시 에러가 발생한다.
public class StreamSortedExample {

    // 스트림 정렬 사용 예
    public static void main(String[] args) {
        List<Person> psersonList = new ArrayList<>();
        psersonList.add(new Person("장윤기", 45));
        psersonList.add(new Person("장해라", 18));
        psersonList.add(new Person("장해운", 14));
        psersonList.add(new Person("장윤기", 45));

        // 데이터를 정렬한 후 출력한다. - 에러 발생
        psersonList.stream().sorted().forEach(System.out::println);
    }
}
