package com.example.Stream;

import java.util.stream.Stream;

/**
 * @author jinwoopark
 */
public class StreamBuilderExample2 {
    // 스트림 빌더의 add 매서드 사용하는 예
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        builder.add("1")
                .add("2")
                .add("3")
                .add("4")
                .add("5")
                .add("6")
                .add("7")
                .add("8")
                .add("9")
                .add("0")
                .build()
                .forEach(System.out::println);
    }
}
