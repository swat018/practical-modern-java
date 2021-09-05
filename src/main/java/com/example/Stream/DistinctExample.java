package com.example.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {
    public static void main(String[] args) {
        Collection<String> list = Arrays.asList("A","B","C","D","A","B","C");

        // 중복 제거된 List 객체 리턴
        List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());

        // 결과 출력
        System.out.println(distinctElements);
    }
}
