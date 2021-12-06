package com.example.Optional;

import java.util.Optional;

public class OptionalHouse {
    // country 속성은 필수값임. Optional에 포함시키지 않음.
    private String country;
    // 나머지 속성은 선택값임.
    private Optional<String> city = Optional.empty();
    private Optional<String> address = Optional.empty();
    private Optional<String> detailAddress = Optional.empty();

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Optional<String> getCity() {
        return city;
    }

    public void setCity(Optional<String> city) {
        this.city = city;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }

    public Optional<String> getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(Optional<String> detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(country).append(" ");

        // Optional 기반 데이터 처리
        city.ifPresent((entity) -> sb.append(entity).append(" "));
        address.ifPresent((entity) -> sb.append(entity).append(" "));
        detailAddress.ifPresent((entity) -> sb.append(entity).append(" "));

        return sb.toString();
    }
}
