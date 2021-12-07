package com.example.Optional;

import java.util.Optional;

/**
 * Optional의 map과 flatMap 메서더를 사용하는 예제
 * @author jinwoopark
 */
public class FlatMapExample {
    private String name;
    private Optional<String> age;

    public FlatMapExample(String name, String age) {
        this.name = name;
        this.age = Optional.ofNullable(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getAge() {
        return age;
    }

    public void setAge(Optional<String> age) {
        this.age = age;
    }

    public static void main(String[] args) {
        FlatMapExample example = new FlatMapExample("JW Park", "38");
        Optional<FlatMapExample> optExample = Optional.of(example);

        // map 이용
        Optional<Optional<String>> age = optExample.map(entity -> entity.getAge());
        System.out.printf("map 결과 : %s\n", age.get().get());

        // flatMap 이용 - 데이터가 평면화된다.
        Optional<String> flatAge = optExample.flatMap(entity -> entity.getAge());
        System.out.printf("map 결과 : %s\n", flatAge.get());

    }
}
