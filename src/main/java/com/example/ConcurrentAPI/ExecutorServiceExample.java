package com.example.ConcurrentAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    // ExecutorService 사용 예
    public static void main(String[] args) {
        // ExecutorService 객체를 생성한다.
//        ExecutorService execService = Executors.newSingleThreadExecutor();

        // 스레드 풀이 2개인 ExecutorService 생성
//        ExecutorService execService = Executors.newFixedThreadPool(2);

        // 캐싱 스레드 풀을 생성
        ExecutorService execService = Executors.newCachedThreadPool();

        // Thread를 생성하고 실행시킨다.
        execService.execute(new MyTask("TODO 1"));
        execService.execute(new MyTask("TODO 2"));
        execService.execute(new MyTask("TODO 3"));
        // ExecutorService를 종료시킨다.
        execService.shutdown();
    }
}

// Runnable을 상속한 태스크를 정의한다.
class MyTask implements Runnable {
    private String id;

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("Task ID : " + id + ", running ..." + i);

            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public MyTask(String id) {
        this.id = id;
    }
}
