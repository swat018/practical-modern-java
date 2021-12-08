package com.example.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList를 참조해서 새로운 List형을 정의하는 예제
 * @author jinwoopark
 */
public class CustomList {
    // 내부 데이터 관리 목적으로 사용
    private List list = new ArrayList();

    public void add(Object element) {
        list.add(element);
    }

    public Object get(int index) {
        return list.get(index);
    }
}
