package com.example.Stream;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int intStreamSum = intList.stream().mapToInt(Integer::intValue).sum();
        System.out.printf("IntStream 이용 sum : %s \n", intStreamSum);
    }
}
