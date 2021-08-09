package com.example.functional_programming;

import com.example.interface_class.Worker;

import java.util.List;

public class excute {

    public static void main(String[] args) {
//        SearchingTravel travelSearch = new SearchingTravel();
//        // 베트남 여행 상품 목록 조회
//        List<TravleInfo> searchList = travelSearch.searchTravelInfo(SearchingTravel.COUNTRY_VIETNAM);
//
//        for(TravleInfo searchTravel : searchList) {
//            System.out.println(searchTravel);
//        }


//        NewMethodSearchingTravel travelSearch = new NewMethodSearchingTravel();
//        // 국가명을 기준으로 조회하는 예제
//        List<TravleInfo> searchListByCountry = travelSearch.searchTravelInfoByCountry("vietnam");
//
//        for(TravleInfo searchTravel : searchListByCountry) {
//            System.out.println(searchTravel);
//        }
//
//        // 도시명을 기준으로 조회하는 예제
//        List<TravleInfo> searchListByCity = travelSearch.searchTravelInfoByCity("cebu");
//
//        for(TravleInfo searchTravel : searchListByCity) {
//            System.out.println(searchTravel);
//        }

        NewSearchingTravel travelSearch = new NewSearchingTravel();

//        // 조회 조건을 외부로 분리
//        List<TravleInfo> searchTravel = travelSearch.searchTravelInfo(new TravelInfoFilter() {
//            @Override
//            public boolean isMatched(TravleInfo travelInfo) {
//                if(travelInfo.getCountry().equals("vietnam")) {
//                    return true;
//                }
//                else {
//                    return false;
//                }
//            }
//        });
//
//        for(TravleInfo travleInfo : searchTravel) {
//            System.out.println(travleInfo);
//        }

        // 국가명을 기준으로 조회하는 예제
        List<TravleInfo> searchListByCountry =
                travelSearch.searchTravelInfo((TravleInfo travleInfo) -> travleInfo.getCountry().equals("vietnam"));
        for(TravleInfo travleInfo : searchListByCountry) {
            System.out.println(travleInfo);
        }

        // 도시명을 기준으로 조회하는 예제
        List<TravleInfo> searchListByCity =
                travelSearch.searchTravelInfo((TravleInfo travleInfo) -> travleInfo.getCity().equals("hanoi"));
        for(TravleInfo travleInfo : searchListByCity) {
            System.out.println(travleInfo);
        }


    }
}
