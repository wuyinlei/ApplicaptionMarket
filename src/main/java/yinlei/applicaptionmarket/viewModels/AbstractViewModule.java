package yinlei.applicaptionmarket.viewModels;

import android.util.Log;

import rx.subscriptions.CompositeSubscription;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: AbstractViewModule.java
 * @author: myName
 * @date: 2016-07-03 18:40
 */

public abstract class AbstractViewModule {

    private static final String TAG = AbstractViewModule.class.getCanonicalName();

    private CompositeSubscription mCompositeSubscription;


    final public void subscribeToDataStore() {
        Log.v(TAG, "subscribeToDataStore");
        unsubscribeFromDataStore();
        mCompositeSubscription = new CompositeSubscription();
        subscribeToDataStoreInternal(mCompositeSubscription);
    }

    public void dispose() {
        Log.v(TAG, "dispose");

        if (mCompositeSubscription != null) {
            Log.e(TAG, "Disposing without calling unsubscribeFromDataStore first");

            // Unsubscribe in case we are still for some reason subscribed
            unsubscribeFromDataStore();
        }
    }

    abstract void subscribeToDataStoreInternal(CompositeSubscription compositeSubscription);

    public void unsubscribeFromDataStore() {
        Log.v(TAG, "unsubscribeToDataStore");
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
            mCompositeSubscription = null;
        }
    }
}
