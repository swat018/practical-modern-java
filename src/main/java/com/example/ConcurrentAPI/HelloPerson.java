package com.example.ConcurrentAPI;

import java.util.ArrayList;
import java.util.List;

public class HelloPerson {
    private String firstName;
    private String lastName;
    private String Country;

    public HelloPerson(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        Country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " from " + this.getCountry();
    }

    public static List<HelloPerson> getSampleDate() {
        // List 객체를 생성한다.
        List<HelloPerson> person = new ArrayList<HelloPerson>();

        // 테스트 데이터를 추가한다.
        person.add(new HelloPerson("진우", "박", "대한민국"));
        person.add(new HelloPerson("혜빈", "유", "미국"));
        person.add(new HelloPerson("현지", "박", "중국"));
        person.add(new HelloPerson("서진", "박", "일본"));
        person.add(new HelloPerson("태양", "박", "남극"));

        return person;
    }
}
