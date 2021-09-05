package com.example.Stream;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name : " + name + ", Age : " + age;
    }

    // 정확한 비교를 위해 equals 메서드를 오버라이드했다.
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        // age 속성과 name 속성이 모두 동일해야 같은 값으로 리턴한다.
        if(obj instanceof Person) {
            Person p1 = (Person)obj;

            if(p1.getName().equals(this.getName()) && p1.getAge() == this.getAge()) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    // 정확한 비교를 위해 hashCode 메서드를 오버라이드했다.
    @Override
    public int hashCode() {
        return (name + age).hashCode();
    }
}
