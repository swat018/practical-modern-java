package com.example.functional_programming;

import com.example.interface_class.Worker;

import java.util.List;

public class excute {

    public static void main(String[] args) {
        SearchingTravel travelSearch = new SearchingTravel();
        // 베트남 여행 상품 목록 조회
        List<TravleInfo> searchList = travelSearch.searchTravelInfo(SearchingTravel.COUNTRY_VIETNAM);

        for(TravleInfo searchTravel : searchList) {
            System.out.println(searchTravel);
        }
    }
}
