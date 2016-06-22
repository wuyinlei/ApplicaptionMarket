package yinlei.applicaptionmarket.ui.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.adapter.TabViewPagerAdapter;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;
import yinlei.applicaptionmarket.ui.fragment.AppFragment;
import yinlei.applicaptionmarket.ui.fragment.DiscoverFragment;
import yinlei.applicaptionmarket.ui.fragment.GameFragment;

public class MainActivity extends BaseAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;
    @Bind(R.id.nav_view)
    NavigationView mNavView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //initImmersive();
        //initToolbar();
        initUI();
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
        return R.layout.activity_main;
    }

    /**
     * 初始化UI控件
     */
    private void initUI() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
        initToolbar();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close
        );
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();   //点击出现/隐藏左侧布局
        mNavView.setNavigationItemSelectedListener(this);
        initTabs();
        //initImmersive();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItemNotification = menu.findItem(R.id.action_notification);
        menuItemNotification.setIcon(R.mipmap.ic_menu_notification);

        MenuItem menuItemSearch = menu.findItem(R.id.action_search);
        menuItemSearch.setIcon(R.mipmap.ic_menu_search);

        MenuItem menuItemShare = menu.findItem(R.id.action_share);
        menuItemShare.setIcon(R.mipmap.ic_menu_share);

        return true;
    }

    /**
     * 根据获得的系统的消息的个数，在消息提醒上显示消息条目
     *
     * @param count             消息个数
     * @param backgroundImageId 背景图片ID
     * @return
     */
    private Drawable buildCounterDrawable(int count, int backgroundImageId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.notification_count_layout, null);
        view.setBackgroundResource(backgroundImageId);
        TextView tvCount = (TextView) view.findViewById(R.id.tvCount);
        if (count == 0) {
            tvCount.setVisibility(View.GONE);
        } else {
            tvCount.setVisibility(View.VISIBLE);
            tvCount.setText(String.valueOf(count));
        }

        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(getResources(), bitmap);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_notification:
                Toast.makeText(this, "通知", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 初始化tab
     */
    private void initTabs() {
        TabViewPagerAdapter viewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager());

        AppFragment appFragment = new AppFragment();
        GameFragment gameFragmet = new GameFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();

        viewPagerAdapter.addFragment(appFragment, getId(R.string.fragment_app));
        viewPagerAdapter.addFragment(gameFragmet, getId(R.string.fragment_game));
        viewPagerAdapter.addFragment(discoverFragment, getId(R.string.fragment_discover));
        mViewpager.setAdapter(viewPagerAdapter);

        //布局
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.fragment_app));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.fragment_game));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.fragment_discover));
        mTabLayout.setupWithViewPager(mViewpager);  //把Tablayout和viewpager绑定到一起
    }

    /**
     * 沉浸式状态栏
     */
    private void initImmersive() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        }
    }

    /**
     * 得到values文件中string中的字符串
     *
     * @param id 传入的id
     * @return 字符串
     */
    private String getId(int id) {
        return getResources().getString(id);
    }


    private void initToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        assert mToolbar != null;
        mToolbar.setNavigationIcon(R.mipmap.drawer_menu_icon); //设置导航栏图标
        mToolbar.setTitle(getString(R.string.app_name)); //设置title
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_application_manager://应用管理
                Toast.makeText(this, "应用管理", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_detection_update://检测更新
                Toast.makeText(this, "检测更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_setting://设置
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_about://关于
                AboutActivity.startActivity(this,"https://github.com/wuyinlei/ApplicaptionMarket");
                break;
            case R.id.item_feed_back://反馈

                break;
            default:
                break;
        }
        return true;
    }
}
