package com.example.Lambda;

import java.util.function.Predicate;

public class PredicateAndExample {
    // 남자인지 판단
    public static Predicate<Person> isMale() {
        return (Person p) -> "male".equals(p.getSex());
    }
    // 성인인지 판단
    public static Predicate<Person> isAdult() {
        return (Person p) -> p.getAge() > 20;
    }

    //Predicate 조합 예
    public static void main(String[] args) {
        Predicate<Person> predicateA = PredicateAndExample.isMale();
        Predicate<Person> predicateB = PredicateAndExample.isAdult();

        //Predicate 객체 조합
        Predicate<Person> predicateAB = predicateA.and(predicateB);

        Person person = new Person();
        person.setName("jinwoo");
        person.setAge(35);
        person.setSex("male");

        System.out.println(person.getName() + "'s result : " + predicateAB.test(person));
    }
}
