package com.example.lambda;

import java.util.function.Function;

public class FunctionAndThenExample {
    // Function 인터페이스 조합 예
    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = (String str) -> Integer.parseInt(str) + 1;
        Function<Integer, String> intToStrFunction = (Integer i) -> "String : " + Integer.toString(i);

        System.out.println(parseIntFunction.apply("1000"));
        System.out.println(intToStrFunction.apply(1000));
        // Function 객체 조합 후 실행
        System.out.println(parseIntFunction.andThen(intToStrFunction).apply("1000"));
    }
}
