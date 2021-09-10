package com.example.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // IntStream 인터페이스 이용
        int intStreamSum = intList.stream().mapToInt(Integer::intValue).sum();
        System.out.printf("IntStream 이용 sum : %s \n", intStreamSum);

        // 스트림의 collect 연산을 이용
        int sum2 = intList.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.printf("Stream.collect 이용 sum : %s \n", sum2);

        // 메서드 참조로 정의
        int sum3 = intList.stream().reduce(0, Integer::sum);
        System.out.printf("Stream.reduce 이용 sum : %s \n", sum3);
    }
}
