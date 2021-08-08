package com.example;

public class KoreaHouseAddress implements HouseAddress{

    private String postCode;
    private String address;
    private String detailAddress;

    public KoreaHouseAddress(String postCode, String address, String detailAddress) {
        this.postCode = postCode;
        this.address = address;
        this.detailAddress = detailAddress;
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
        return detailAddress;
    }
}
