package ca.amandeep.playernumber.core;

import rx.Subscriber;

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private static final String TAG = "BaseSubscriber";

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        Logger.d(TAG, "subscriber failed", e);
    }
}
