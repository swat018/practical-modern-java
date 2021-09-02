package com.example.lambda;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    // BinaryOperator 인터페이스 사용 예
    public static void main(String[] args) {
        BinaryOperator<Integer> operatorA = (Integer a, Integer b) -> a + b;

        System.out.println(operatorA.apply(1,2));
        System.out.println(operatorA.apply(2,3));
        System.out.println(operatorA.apply(3,4));
    }
}
