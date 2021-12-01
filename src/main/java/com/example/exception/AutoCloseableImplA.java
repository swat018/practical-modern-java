package com.example.exception;

public class AutoCloseableImplA implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println(this.getClass().getName() + "는 종료되었습니다.");
    }
}
