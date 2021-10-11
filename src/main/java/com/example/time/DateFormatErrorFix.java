package com.example.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * SimpleDateFormat 사용 시 에러가 발생하지 않도록 수정한 예쩨
 * @author jinwoopark
 */
public class DateFormatErrorFix {
    public static void main(String[] args) throws Exception {
        // 필요할 때마다 생성한다.
        Callable<Date> task = () -> new SimpleDateFormat("yyyyMMdd").parse("20101022");

        // 스레드 풀 5개 생성
        ExecutorService exec = Executors.newFixedThreadPool(5);
        List<Future<Date>> results = new ArrayList<Future<Date>>();

        // 5개의 스레드에서 동시 처리
        for(int i=0; i<100; i++) {
            results.add(exec.submit(task));
        }
        exec.shutdown();

        // 정상 처리
        for(Future<Date> result : results) {
            System.out.println(result.get());
        }
    }
}
