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

    // 비동기 처리하는 API
    public Future<Integer> calculatePriceAsync(Map condition) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        // 스레드를 생성하고 실행할 작업을 CompletableFuture에 등록한다.
        new Thread( () -> {
            int price = calculatePrice(condition);
            // 처리 상태에 대한 레퍼런스를 등록한다.
            future.complete(price);
        }).start();
        return future;
    }

    public static void main(String[] args) {
        InsuranceCalculator cal = new InsuranceCalculator();

        // 동기 방식 처리
        System.out.println("동기 방식 호출");
        // 5회 걸쳐 계산한다.
        for(int i=0; i<5; i++) {
            System.out.printf("계산 차수 %s : %s\n", (i+1), cal.calculatePrice(null));
        }

        // 비동기 방식 처리 1
        System.out.println("비동기 방식 호출 1");
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

        // 비동기 방식 처리 2
        System.out.println("비동기 방식 호출 2");

        futureList.clear();

        for(int i=0; i<5; i++) {
            Future<Integer> future = cal.calculatePriceAsync(null);
            futureList.add(future);
        }

        futureList.forEach((future) -> {
           try {
               System.out.printf("계산 결과 : %s\n", future.get());
           } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
           }
        });
    }
}
