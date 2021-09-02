package com.example.lambda;

import java.util.function.IntPredicate;

public class IntPredicateExample {
    // integer 형만을 허용하는 Predicate 인터페이스로 정의
    public static boolean isPositive(int i, IntPredicate intPredicate) {
        return intPredicate.test(i);
    }

    // IntPredicate 인터페이스 실행 예
    public static void main(String[] args) {
        for(int i=0; i<1_000_000; i++){
            System.out.println(IntPredicateExample.isPositive(i, (int integerValue) -> integerValue > 0));
        }
    }
}
