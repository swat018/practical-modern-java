package com.example.functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SearchingTravel {

    public static final String COUNTRY_VIETNAM = "vietnam";
    public static final String COUNTRY_PHILLIPHINE = "philliphine";
    public static final String COUNTRY_TAILAND = "tailand";

    // 여행 상품 저장
    private List<TravleInfo> travleInfoList = new ArrayList<>();

    public SearchingTravel() {
        initializeProduct();
    }

    // 데이터를 초기화하여 외부에서 호출하지 못하도록 private으로 선언
    private void initializeProduct() {
        TravleInfo cebu = new TravleInfo();
        cebu.setName("Cebu Travel");
        cebu.setCountry(COUNTRY_PHILLIPHINE);
        cebu.setCity("cebu");
        cebu.setDays(5);
        cebu.setNights(3);
        travleInfoList.add(cebu);

        TravleInfo boracay = new TravleInfo();
        boracay.setName("Boracay Travel");
        boracay.setCountry(COUNTRY_PHILLIPHINE);
        boracay.setCity("boracay");
        boracay.setDays(5);
        boracay.setNights(3);
        travleInfoList.add(boracay);

        TravleInfo hanoi = new TravleInfo();
        hanoi.setName("Hanoi Travel");
        hanoi.setCountry(COUNTRY_VIETNAM);
        hanoi.setCity("hanoi");
        hanoi.setDays(3);
        hanoi.setNights(2);
        travleInfoList.add(hanoi);

        TravleInfo danang = new TravleInfo();
        danang.setName("Danang Travel");
        danang.setCountry(COUNTRY_VIETNAM);
        danang.setCity("danang");
        danang.setDays(6);
        danang.setNights(4);
        travleInfoList.add(danang);

        TravleInfo bankok = new TravleInfo();
        bankok.setName("Bankok Travel");
        bankok.setCountry(COUNTRY_TAILAND);
        bankok.setCity("bankok");
        bankok.setDays(5);
        bankok.setNights(3);
        travleInfoList.add(bankok);
    }

    // 국가 정보에 기반해서 여행 상품을 조회한다.
    public List<TravleInfo> searchTravelInfo(String country) {
        List<TravleInfo> returnValue = new ArrayList<>();

        for(TravleInfo travleInfo : travleInfoList) {
            if(country.equals(travleInfo.getCountry())) {
                returnValue.add(travleInfo);
            }
        }

        return returnValue;
    }
}
