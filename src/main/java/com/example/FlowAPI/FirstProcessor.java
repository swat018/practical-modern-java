package com.example.FlowAPI;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Processor는 Subscriber와 Publisher의 기능을 모두 가지고 있다.
 * @author jinwoopark
 */
public class FirstProcessor<T, R> extends SubmissionPublisher<R> implements Flow.Processor<T, R> {
    private Function<T, R> function;
    private Flow.Subscription subscription;

    public FirstProcessor(Function<T, R> function) {
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        submit(function.apply(item));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        close();
    }

    public static void main(String[] args) throws Exception {
        ConcurrentPublisher<String> publisher = new ConcurrentPublisher<>();
        FirstProcessor<String, String> processor = new FirstProcessor<>(name -> name + " 값을 변환");

        FirstSubscriber<String> subscriber1 = new FirstSubscriber<>("Subscriber 1", 10);
        FirstSubscriber<String> subscriber2 = new FirstSubscriber<>("Subscriber 2", 10);

        // publisher에 processor를 등록한다.
        publisher.subscribe(processor);
        // processor에 subscriber1을 등록한다.
        processor.subscribe(subscriber1);
        // processor에 subscriber2을 등록한다.
        processor.subscribe(subscriber2);

        TimeUnit.SECONDS.sleep(10);
    }
}
