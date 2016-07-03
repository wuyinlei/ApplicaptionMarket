package yinlei.applicaptionmarket.network;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import yinlei.applicaptionmarket.contants.Constants;
import yinlei.applicaptionmarket.pojo.UserInfo;

/**
 * 网络请求
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: NetWorkApi.java
 * @author: 若兰明月
 * @date: 2016-07-03
 */

public class NetWorkApi {
    private AppService mAppService;

    public NetWorkApi() {
        OkHttpClient okHttpClient = new OkHttpClient();
        //设置请求超时  读取超时  写入超时
        okHttpClient.newBuilder().connectTimeout(10, TimeUnit.SECONDS);
        okHttpClient.newBuilder().readTimeout(10, TimeUnit.SECONDS);
        okHttpClient.newBuilder().writeTimeout(10, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ServletUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mAppService = retrofit.create(AppService.class);

    }

    /**
     * 用户登录
     * @param userName  用户名
     * @param pwd  密码
     * @return
     */
    public Observable<UserInfo> login(String userName, String pwd) {
        return mAppService.login(userName, pwd);
    }
}
