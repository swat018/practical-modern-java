package com.example.FlowAPI;

import java.util.concurrent.*;
import java.util.concurrent.Flow.Subscriber;

/**
 * 병렬 처리 가능한 Publisher를 구현한 예제
 * @author jinwoopark
 */
public class ConcurrentPublisher<T> implements Flow.Publisher<String> {
    // ExcutorService 객체를 생성한다.
    private final ExecutorService executor = ForkJoinPool.commonPool();

    @Override
    public synchronized void subscribe(Subscriber<? super String> subscriber) {
        MySubscription subscription = new MySubscription(subscriber, executor);
        subscriber.onSubscribe(subscription);
    }

    static class MySubscription implements Flow.Subscription {
        // ExecutorService를 이용해서 병렬 처리한다.
        private ExecutorService executor;
        private Subscriber<? super String> subscriber;
        private Future<?> future;

        public MySubscription(Subscriber<? super String> subscriber, ExecutorService executor) {
            this.subscriber = subscriber;
            // Publisher로부터 ExcutorService를 전달받는다.
            this.executor = executor;
        }

        @Override
        public void request(long n) {
            // 비동기 호출을 한다.
            future = executor.submit(() -> publishItems(n));
        }

        @Override
        public void cancel() {
            if(future != null) future.cancel(false);
            System.out.println("Canceled");
        }

        private void publishItems(long n) {
            // n번 반복해서 메시지를 전송한다.
            for(var i=0; i<n; i++) {
                subscriber.onNext("Hello Subscriber!! " + n);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        ConcurrentPublisher<String> publisher = new ConcurrentPublisher<>();
        publisher.subscribe(new FirstSubscriber<>("Subscriber 1", 10));
        publisher.subscribe(new FirstSubscriber<>("Subscriber 2", 10));

        TimeUnit.SECONDS.sleep(20);
    }

}
