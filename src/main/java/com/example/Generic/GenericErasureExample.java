package com.example.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 제네릭 타입 사용 에제
 * @author jinwoopark
 */
public class GenericErasureExample {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("Hello");
        myList.add("World");

        String hello = myList.get(0);
        String world = myList.get(1);

        System.out.println(hello + " " + world);
    }
}
