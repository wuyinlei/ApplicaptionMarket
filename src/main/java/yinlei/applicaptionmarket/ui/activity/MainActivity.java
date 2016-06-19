package yinlei.applicaptionmarket.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;

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
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //initImmersive();
        //initToolbar();
        initUI();
    }

    /**
     * 初始化UI控件
     */
    private void initUI() {
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorPrimary));
        initToolbar();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close
        );
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();   //点击出现/隐藏左侧布局
        mNavView.setNavigationItemSelectedListener(this);
        initTabs();
    }

    /**
     * 初始化tab
     */
    private void initTabs() {
        TabViewPagerAdapter viewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager());

        AppFragment appFragment = new AppFragment();
        GameFragment gameFragmet = new GameFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();

        viewPagerAdapter.addFragment(appFragment,getId(R.string.fragment_app));
        viewPagerAdapter.addFragment(gameFragmet,getId(R.string.fragment_game));
        viewPagerAdapter.addFragment(discoverFragment,getId(R.string.fragment_discover));
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
     * @param id   传入的id
     * @return  字符串
     */
    private String getId(int id){
        return getResources().getString(id);
    }



    private void initToolbar() {
        if(mToolbar != null){
            setSupportActionBar(mToolbar);
        }
        assert mToolbar != null;
        mToolbar.setNavigationIcon(R.mipmap.drawer_menu_icon); //设置导航栏图标
        mToolbar.setTitle(getString(R.string.app_name)); //设置title
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
