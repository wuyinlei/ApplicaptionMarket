package yinlei.applicaptionmarket.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.adapter.ListAppAdapter;
import yinlei.applicaptionmarket.ui.base.BaseFragment;

/**
 * 应用fragment
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: AppFragment.java
 * @author: 若兰明月
 * @date: 2016-06-19 16:03
 */

public class AppFragment extends BaseFragment {
    RecyclerView recyclerView;

    @Override
    public void initUI(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void initData() {
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        recyclerView.setAdapter(new ListAppAdapter(getActivity(), datas));
    }

    @Override
    public void initInjector() {

    }

    @Override
    public void getBundle(Bundle bundle) {

    }


    @Override
    public int initContentView() {
        return R.layout.fragment_app;
    }


}
