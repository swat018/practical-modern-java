package com.example.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortCollection {

    // 생행하기 위한 예제이다.
    public static void main(String[] args) {
        List<BaseballPlayer> list = new ArrayList<BaseballPlayer>();

        // 정렬을 위한 규칙을 정의한다.
        // 자바 8 이상에서만 컴파일된다.
//        list.sort(new Comparator<BaseballPlayer>() {
//
//            @Override
//            public int compare(BaseballPlayer o1, BaseballPlayer o2) {
//                return o1.getPlayerName().compareTo(o2.getPlayerName());
//            }
//        });

        list.sort(
                (BaseballPlayer object1, BaseballPlayer object2)
                -> object1.getPlayerName().compareTo(object2.getPlayerName())
        );
    }
}
