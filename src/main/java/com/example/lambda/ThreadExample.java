package com.example.lambda;

public class ThreadExample {

    public static void main(String[] args) {
        // 익명 클래스
//        // 스레드를 생성한다.
//        Thread thread = new Thread(new Runnable() {
//            // run 메서드를 구현한다.
//            @Override
//            public void run() {
//                System.out.println("Hello World");
//            }
//        });
//
//        thread.start();
//    }
        // 람다 표현식으로 전환
//        Thread thread = new Thread( () -> System.out.println("Hello World") );

        // 코드를 분리
//        Runnable runImpl = () -> System.out.println("Hello World");
//        Thread thread = new Thread(runImpl);

        // 메서드로 변형
        Runnable runImpl = getRunnable();
        Thread thread = new Thread(runImpl);

        thread.start();
    }
    public static Runnable getRunnable() {
        return () -> System.out.println("Hello World"); // Runnable 객체를 생성해서 리턴
    }
}
