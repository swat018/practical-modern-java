package com.example.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * E로 오는 데이터 타입에 대해서만 사용할 수 있도록 제한하였다.
 * @author jinwoopark
 */
//public class GenericCustomList<E> {
//    private List<E> list = new ArrayList<>();
//
//    public void add(E element) {
//        list.add(element);
//    }
//
//    public E get (int index) {
//        return list.get(index);
//    }
//}
/**
 * String 클래스만을 허용하는 제네릭 선언 예제
 * @author jinwoopark
 */
public class GenericCustomList<String> {
    private List<String> list = new ArrayList<>();

    public void add(String element) {
        list.add(element);
    }

    public String get (int index) {
        return list.get(index);
    }
}