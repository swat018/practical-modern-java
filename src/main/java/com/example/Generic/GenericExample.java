package com.example.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 제네릭과 연관된 객체의 인스턴스 타입을 구하는 예제
 * @author jinwoopark
 */
public class GenericExample {

    public static void main(String[] args) {
        // 3가지 타입의 List 객체를 생성
        List myList = new ArrayList();
        List<String> stringList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();

        // instanceof로 인스턴스 타입 확인
        System.out.println(myList instanceof ArrayList);
//        System.out.println(stringList instanceof ArrayList<String>);    // 에러
//        System.out.println(integerList instanceof ArrayList<Integer>);    // 에러
//        System.out.println(stringList instanceof ArrayList);
//        System.out.println(integerList instanceof ArrayList);
        System.out.println(stringList instanceof ArrayList<?>);
        System.out.println(integerList instanceof ArrayList<?>);
    }
}
