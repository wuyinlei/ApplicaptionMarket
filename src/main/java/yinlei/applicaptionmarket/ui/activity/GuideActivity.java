package yinlei.applicaptionmarket.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.common.AppConstant;
import yinlei.applicaptionmarket.common.MyApplication;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;
import yinlei.applicaptionmarket.ui.widget.ColorAnimationView;
import yinlei.applicaptionmarket.ui.widget.PagerAdapter;
import yinlei.applicaptionmarket.ui.widget.ViewPager;
import yinlei.applicaptionmarket.utils.SharedPreferencesUtils;

public class GuideActivity extends BaseAppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {


    private List<View> pagers = new ArrayList<>();
    private FragmentPagerAdapter mPagerAdapter;

    @Bind(R.id.ColorAnimationView)
    ColorAnimationView mColorAnimationView;
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        SharedPreferencesUtils.putString(this, AppConstant.GUIDE_SHOW, MyApplication.getApplication().getVersion());
        View view_guide01 = LayoutInflater.from(this).inflate(R.layout.guide_layout, null);
        view_guide01.findViewById(R.id.guide_point).setBackgroundResource(R.mipmap.guide_01_point);

        View view_guide02 = LayoutInflater.from(this).inflate(R.layout.guide_layout, null);
        view_guide02.findViewById(R.id.guide_point).setBackgroundResource(R.mipmap.guide_02_point);

        View view_guide03 = LayoutInflater.from(this).inflate(R.layout.guide_layout, null);
        view_guide03.findViewById(R.id.guide_point).setBackgroundResource(R.mipmap.guide_03_point);

        View view_guide04 = LayoutInflater.from(this).inflate(R.layout.guide_layout, null);
        view_guide04.findViewById(R.id.guide_point).setBackgroundResource(R.mipmap.guide_04_point);
        view_guide04.findViewById(R.id.btnMain).setVisibility(View.VISIBLE);
        view_guide04.findViewById(R.id.btnMain).setOnClickListener(this);
        pagers.add(view_guide01);
        pagers.add(view_guide02);
        pagers.add(view_guide03);
        pagers.add(view_guide04);

        mPagerAdapter = new FragmentPagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(this);
        mColorAnimationView.setmViewPager(mViewPager, 4, 0xff7edd61, 0xffff704a, 0xff5d7ac5, 0xff56c8f2);

    }

    @Override
    protected void initUiAndListener() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    public int initContentView() {
        return R.layout.activity_guide;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private class FragmentPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pagers.get(position));
            return pagers.get(position);

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
