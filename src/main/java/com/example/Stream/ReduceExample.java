package com.example.Stream;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum[]  = {0};

        intList.stream().forEach(value -> sum[0] += value);
        System.out.printf("sum : %s \n", sum[0]);
    }
}
