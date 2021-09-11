package com.example.Lambda;

import java.util.function.Function;

public class FunctionComposeExample {

    // Functipn 인터페이스의 compose 예
    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = (String str) -> Integer.parseInt(str) + 1;
        Function<Integer, String> intToStrFunction = (Integer i) -> "String : " + Integer.toString(i);

        System.out.println(parseIntFunction.apply("1000"));
        System.out.println(intToStrFunction.apply(1000));
        // 2개의 람다 표현식을 조합
        System.out.println(intToStrFunction.compose(parseIntFunction).apply("1000"));
    }
}
