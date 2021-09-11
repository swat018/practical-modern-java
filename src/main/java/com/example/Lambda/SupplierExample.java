package com.example.Lambda;

import java.util.function.Supplier;

public class SupplierExample {
    public static String executeSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    //Supplier 인터페이스 실행 예
    public static void main(String[] args) {
        String version = "java upgrade book, version 0.1 BETA";
        System.out.println(SupplierExample.executeSupplier(() -> {return version;}));
    }
}
