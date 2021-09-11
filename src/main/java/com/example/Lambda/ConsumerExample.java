package com.example.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void executeConsumer(List<String> nameList, Consumer<String> consumer) {
        for(String name : nameList) {
            // 메서드의 두 번째 인수로 전달된 람다 표현식을 실행시킨다.
            consumer.accept(name);
        }
    }

    //Consumer 인터페이스 활용 예쩨
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("정수빈");
        nameList.add("김재호");
        nameList.add("오재원");
        nameList.add("이영하");
        ConsumerExample.executeConsumer(nameList, (String name) -> System.out.println(name));
    }
}
