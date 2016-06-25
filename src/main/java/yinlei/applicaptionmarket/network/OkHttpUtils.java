package yinlei.applicaptionmarket.network;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求辅助类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: OkHttpUtils.java
 * @author: 若兰明月
 * @date: 2016-06-25 10:36
 */

public class OkHttpUtils {

    private static final OkHttpClient mOkHttpClient = new OkHttpClient();

    /**
     * 不开启异步线程
     *
     * @param request 请求参数
     * @return
     * @throws IOException
     */
    public static Response execute(Request request) throws IOException {
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * 开启异步线程访问网络
     *
     * @param request          请求参数
     * @param responseCallback 返回结果回调
     */
    public static void enqueue(Request request, Callback responseCallback) {
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }


    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     *
     * @param request
     */
    public static void enqueue(Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
