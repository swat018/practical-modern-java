package com.example.Generic;

import java.util.HashMap;
import java.util.Map;

/**
 * 멀티 타입 파라미터로 제네릭을 선언한 클래스 예제
 * @author jinwoopark
 */
public class GenericCustomMap<K, V> {
    private Map<K, V> map = new HashMap<K, V>();

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }
}
