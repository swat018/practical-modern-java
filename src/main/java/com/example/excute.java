package com.example;

public class excute {

    public static void main(String[] args) {
        KoreaHouseAddress koreaHouseAddress = new KoreaHouseAddress("123","서울시 관악구","신림동");
        System.out.println(koreaHouseAddress.getAddress());
        System.out.println(koreaHouseAddress.getPostCode());
        System.out.println(koreaHouseAddress.getDetailAddress());
    }
}
