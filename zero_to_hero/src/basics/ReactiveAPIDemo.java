package basics;

import java.util.concurrent.Flow;

class SimplePublisher implements Flow.Publisher<String> {
    private String[] data;

    public SimplePublisher(String[] data) {
        this.data = data;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        subscriber.onSubscribe(new Flow.Subscription() {
            private int index = 0;
            private boolean canceled = false;

            @Override
            public void request(long n) {
                for (int i = 0; i < n && index < data.length && !canceled; i++) {
                    subscriber.onNext(data[index++]);
                }
                if (index == data.length) {
                    subscriber.onComplete();
                }
            }

            @Override
            public void cancel() {
                canceled = true;
            }
        });
    }
}

class SimpleSubscriber implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Received: " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All items received!!");
    }
}

public class ReactiveAPIDemo {
    public static void main(String[] args) {
        String[] data = {"Hello", "world", "from", "Flow", "API"};
        SimplePublisher simplePublisher = new SimplePublisher(data);
        SimpleSubscriber simpleSubscriber = new SimpleSubscriber();

        simplePublisher.subscribe(simpleSubscriber);
    }
}
