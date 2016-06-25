package yinlei.applicaptionmarket.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.data.ActivityComponent;
import yinlei.applicaptionmarket.data.ActivityModule;
import yinlei.applicaptionmarket.data.DaggerActivityComponent;
import yinlei.applicaptionmarket.network.OkHttpUtils;
import yinlei.applicaptionmarket.pojo.UserInfo;
import yinlei.applicaptionmarket.ui.base.BaseFragment;

/**
 * 发现fragment
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: DiscoverFragment.java
 * @author: 若兰明月
 * @date: 2016-06-19 16:03
 */

public class DiscoverFragment extends BaseFragment {

    @Inject
    UserInfo userInfo;
    @Bind(R.id.get_btu)
    Button mGetBtu;
    @Bind(R.id.result)
    TextView mResult;

    private String url = "http://112.124.22.238:8081/course_api/auth/login?phone=15677975034&password=cniaowo12345678";


    private ActivityComponent mActivityComponent;


    @Override
    public void initUI(View view) {
        ButterKnife.bind(this, view);

    }

    @Override
    public void initData() {
        mGetBtu.setOnClickListener(v -> {
            FormBody formBody = new FormBody.Builder()
                    .add("Content-Type", "application/json")
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            Callback callback = new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {

                    UserInfo userInfo1 = new UserInfo();
                    userInfo.setMessage("测试依赖注入");
                   // Gson gson = new Gson();
                   // userInfo1 = gson.fromJson(response.body().string(),UserInfo.class);
                    if(response.isSuccessful()){
                        final UserInfo finalUserInfo = userInfo1;
                        getActivity().runOnUiThread(() -> mResult.setText(userInfo.getMessage()));
                    }
                }
            };
            OkHttpUtils.enqueue(request, callback);

        });
    }

    @Override
    public void initInjector() {
        mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        mActivityComponent.inject(this); //完成依赖注入
    }

    @Override
    public void getBundle(Bundle bundle) {

    }


    @Override
    public int initContentView() {
        return R.layout.fragment_discover;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
