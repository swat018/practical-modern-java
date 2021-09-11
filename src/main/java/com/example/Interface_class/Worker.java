package com.example.Interface_class;

public class Worker implements Female, Male{

    public static final String MALE = "male";
    public static final String FEMALE = "femail";

    private int age;
    private String name;
    private String sex;

    public Worker(String name, int age, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String getSex() {
        String returnValue = null;
        if(sex != null && "male".equals(sex)) {
            returnValue = Male.super.getSex();
        }
        else if(sex != null && "female".equals(sex)) {
            returnValue = Female.super.getSex();
        }
        else {
            returnValue = "N/A";
        }
        return returnValue;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return "Name : " + name + " is " + age + " years old";
    }
}
