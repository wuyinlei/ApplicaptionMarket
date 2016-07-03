package yinlei.applicaptionmarket.data;

import rx.Observable;
import rx.schedulers.Schedulers;
import yinlei.applicaptionmarket.network.NetWorkApi;
import yinlei.applicaptionmarket.pojo.UserInfo;

/**
 * 具体的数据获取的类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: DataLayer.java
 * @author: 若兰明月
 * @date: 2016-07-03
 */

public class DataLayer {

    private final NetWorkApi mNetWorkApi;


    public DataLayer() {
        mNetWorkApi = new NetWorkApi();
    }

    /**
     * 用户登录
     *
     * @param userName
     * @param pwd
     * @return
     */
    public Observable<UserInfo> toLogin(String userName, String pwd) {
        Observable<UserInfo> observable = mNetWorkApi
                .login(userName, pwd);
        /**
         * 我的理解是subscribeOn是影响生产者（Observable）
         * 生产数据的线程的，通常我们只需要指定生产者在某一个特
         * 定的线程生产数据就可以满足我们的需求，至少我还没遇到
         * 过需要在生产数据的过程中去切换生产者所在的线程的情况。
         * 绝大多数我们需要变化线程的场景都是在数据生产之后，
         * Rx里面就使用observeOn来指定各种operator和subcriber
         * 的线程，因为这些本质上都是数据的消费者。消费者可以任意
         * 切换自己接受处理数据的线程，足以满足我们的需求
         */
        observable.subscribeOn(Schedulers.io());
        observable.observeOn(Schedulers.io());
        return observable;
    }

    public static interface LoginStore {

        Observable<UserInfo> call(String userName,String pwd);
    }

}
