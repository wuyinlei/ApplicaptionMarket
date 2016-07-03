package yinlei.applicaptionmarket.viewModels;

import javax.inject.Inject;

import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.CompositeSubscription;
import yinlei.applicaptionmarket.common.MyApplication;
import yinlei.applicaptionmarket.data.DataLayer;
import yinlei.applicaptionmarket.pojo.UserInfo;

/**
 * 接受来自DataStoreModule返回的数据
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: UserViewModel.java
 * @author: myName
 * @date: 2016-07-03
 */

public class UserViewModel extends AbstractViewModule {
    private String userName,pswd;
    private static final String TAG = UserViewModel.class.getSimpleName();
    final private BehaviorSubject<UserInfo> repository = BehaviorSubject.create();

    @Inject
    DataLayer.LoginStore loginStore;


    public UserViewModel(){
        MyApplication.getApplication().getGraph().inject(this);
    }

    @Override
    void subscribeToDataStoreInternal(CompositeSubscription compositeSubscription) {

        compositeSubscription.add(
                loginStore.call(userName,pswd)
                        .subscribeOn(Schedulers.io())
                        .subscribe(repository)


        );
    }


    /**
     * 设置登录的用户名和密码
     * @param userName
     * @param pwd
     * @return
     */
    public UserViewModel setUserInfo(String userName,String pwd){
        this.pswd = pwd;
        this.userName = userName;
        return this;
    }



    public BehaviorSubject<UserInfo> getRepository() {

        return repository;
    }
}
