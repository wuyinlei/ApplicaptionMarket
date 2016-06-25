package yinlei.applicaptionmarket.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yinlei.applicaptionmarket.R;

/**
 * Fragment的基类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: BaseFragment.java
 * @author: 若兰明月
 * @date: 2016-06-09 18:35
 */

public abstract class BaseFragment extends Fragment {

    protected String getTAG;

    private String TAG = BaseFragment.class.getSimpleName();

    /**
     * 打开指定类的Activity
     *
     * @param pClass
     */
    protected void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    /**
     * 打开指定的页面，有信息传递
     *
     * @param pClass
     * @param bundle
     */
    private void openActivity(Class<?> pClass, Bundle bundle) {
        Intent intent = new Intent(getActivity(), pClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    protected void openActivity(String pAction) {
        openActivity(pAction, null);
    }

    protected void openActivity(String pAction, Bundle pBundle) {
        Intent intent = new Intent(pAction);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    /**
     * 初始化控件
     */
    public abstract void initUI(View view);

    /**
     * 在监听器之前把数据准备好
     */
    public abstract void initData();

    /**
     * 注入Injector
     */
    public abstract void initInjector();

    /**
     * 得到Activity传进来的值
     */
    public abstract void getBundle(Bundle bundle);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getBundle(getArguments());
        initUI(view);
        initInjector();
        initData();
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(initContentView(), container,false);
    }

    public abstract int initContentView();
}
