package yinlei.applicaptionmarket.utils;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: RxBinderUtils.java
 * @author: 若兰明月
 * @date: 2016-07-03 17:41
 */

public class RxBinderUtils {

    private static final String TAG = RxBinderUtils.class.getCanonicalName();

    private final CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    private String tag;

    public RxBinderUtils(Object target) {
        this.tag = target.getClass().getCanonicalName();
    }

    public void clear() {
        mCompositeSubscription.clear();
    }

    public <U> void bindProperty(Observable<U> observable, Action1<U> setter) {
        mCompositeSubscription.add(subscribeSetter(observable, setter, tag));
    }

    static private <U> Subscription subscribeSetter(
            final Observable<U> observable,
            final Action1<U> setter,
            final String tag
    ) {
        return observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SetterSubscribe<U>(setter, tag));
    }

    static private class SetterSubscribe<U> extends Subscriber<U> {

        final static private String TAG = SetterSubscribe.class.getCanonicalName();

        final private Action1<U> setter;

        final private String tag;

        public SetterSubscribe(final Action1<U> setter,
                               final String tag) {
            this.setter = setter;
            this.tag = tag;
        }

        @Override
        public void onCompleted() {
            Log.v(TAG, tag + " . " + "onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, tag + " . " + "onError", e);
        }

        @Override
        public void onNext(U u) {
            setter.call(u);
        }

        @Override
        public void onStart() {
            super.onStart();
        }
    }

}
