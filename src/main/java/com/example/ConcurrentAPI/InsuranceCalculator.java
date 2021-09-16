package com.example.ConcurrentAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class InsuranceCalculator {
    public int calculatePrice(Map condition) {
        // 기본 가격
        int price = 10000;

        // 보험료 계산하는 로직 대신 10초 대기하는 것으로 대체한다.
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch(Exception e) {}

        // 임의의 가격을 리턴한다.
        return price;
    }

    public static void main(String[] args) {
//        InsuranceCalculator cal = new InsuranceCalculator();
//
//        // 5회 걸쳐 계산한다.
//        for(int i=0; i<5; i++) {
//            System.out.printf("계산 차수 %s : %s\n", (i+1), cal.calculatePrice(null));
//        }
        // 1. 비동기 방식으로 전환
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futureList = new ArrayList<>();;

        for(int i=0;i<5;i++) {
            //비 동기 처리되도록 메서드를 호출하였다.
            Future<Integer> future = service.submit(() -> {
               return new InsuranceCalculator().calculatePrice(null);
            });
            futureList.add(future);
        }

        futureList.forEach((future) -> {
            // 계산 결과를 출력한다.
            try {
                System.out.printf("계산 결과 : %s\n", future.get());
            } catch(InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
