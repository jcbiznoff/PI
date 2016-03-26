package org.in2app;

/**
 * Created by jaychung on 3/24/16.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override
    public void onCompleted() {
        // no-op by default.
    }

    @Override
    public void onError(Throwable e) {
        // no-op by default.
    }

    @Override
    public void onNext(T t) {
        // no-op by default.
    }
}

