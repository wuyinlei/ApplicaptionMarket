package yinlei.applicaptionmarket.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.base.BaseFragment;

/**
 * 应用fragment
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: AppFragment.java
 * @author: 若兰明月
 * @date: 2016-06-19 16:03
 */

public class AppFragment extends BaseFragment{

    public AppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app, container, false);
    }
}
