package com.example.FlowAPI;

import java.util.concurrent.Flow;

/**
 * Publisher를 개발하는 예제
 * @author jinwoopark
 */
public class FirstPublisher<T> implements Flow.Publisher<String> {

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        subscriber.onSubscribe(new MySubscription(subscriber));
    }

    public static void main(String[] args) {
        FirstPublisher<String> publisher = new FirstPublisher<>();
        publisher.subscribe(new FirstSubscriber<>("Subscriber 1", 10));
        publisher.subscribe(new FirstSubscriber<>("Subscriber 2", 10));

    }

    // Subscription를 구현
    class MySubscription implements Flow.Subscription {
        private Flow.Subscriber<? super String> subscriber;


        public MySubscription(Flow.Subscriber<? super String> subscriber) {
            this.subscriber = subscriber;
        }

        @Override
        public void request(long n) {
            publishItem(n);
        }

        @Override
        public void cancel() {
            System.out.println("Canceled");

        }

        private void publishItem(long n) {
            // n번 반복해서 메시지를 전송한다.
            for (var i = 0; i < n; i++) {
                subscriber.onNext("Hello Subscriber!! " + n);
            }
        }
    }
}
