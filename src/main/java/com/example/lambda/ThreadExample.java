package com.example.lambda;

public class ThreadExample {

    public static void main(String[] args) {
        // 스레드를 생성한다.
        Thread thread = new Thread(new Runnable() {
            // run 메서드를 구현한다.
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });

        thread.start();
    }
}
