package com.example.Lambda;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    // UnaryOperator 인터페이스 사용 예
    public static void main(String[] args) {
        UnaryOperator<Integer> operatorA = (Integer t) -> t * 2;

        System.out.println(operatorA.apply(1));
        System.out.println(operatorA.apply(2));
        System.out.println(operatorA.apply(3));
    }
}
