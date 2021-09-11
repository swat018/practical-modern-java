package com.example.Interface_class;

public class KoreaHouseAddress implements HouseAddress{

    private String postCode;
    private String address;
    private String detailAddress;

    public KoreaHouseAddress(String postCode, String address, String detailAddress) {
        this.postCode = postCode;
        this.address = address;
        this.detailAddress = detailAddress;

        System.out.println(postCode + " " + address + " " + detailAddress);
    }

    @Override
    public String getPostCode() {
        return postCode;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getDetailAddress() {
        return getCountryCode();
    }

    @Override
    public String getCountryCode() {
        return HouseAddress.super.getCountryCode(); // 자바 8에 추가된 기능
    }
}
