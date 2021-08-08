package com.example;

public interface HouseAddress {
    public static final String DefaultCountry = "Korea";

    // 우편번호를 리턴한다.
    public String getPostCode();

    // 주소 정보를 리턴한다.
    public String getAddress();

    // 상제 정보를 리턴한다.
    public String getDetailAddress();

    // 국가 코드를 리턴한다.
    default public String getCountryCode() {
        return HouseAddress.DefaultCountry;
    }
}
