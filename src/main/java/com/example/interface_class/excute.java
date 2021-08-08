package com.example.interface_class;

public class excute {

    public static void main(String[] args) {
//        KoreaHouseAddress address = new KoreaHouseAddress("06164","서울특별시 강남구 영동대로 517","아셈타워 12층");
//        System.out.println(address.getCountryCode());

        Worker worker = new Worker("jinwoo", 28, Worker.MALE);
        System.out.println(worker.getInformation() + ", " + worker.getSex());
    }
}
