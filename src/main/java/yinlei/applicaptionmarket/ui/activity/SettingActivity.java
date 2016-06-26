package yinlei.applicaptionmarket.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;
import yinlei.applicaptionmarket.ui.fragment.SettingFragment;

public class SettingActivity extends BaseAppCompatActivity {

    public static void startActivity(Context context){
        Intent intent = new Intent(context,SettingActivity.class);
        context.startActivity(intent);
    }

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void initUiAndListener() {
        ButterKnife.bind(this);
        initToolBar(mToolbar);
        setTitle("设置");
        getFragmentManager().beginTransaction().replace(R.id.content,new SettingFragment()).commit();
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    public int initContentView() {
        return R.layout.activity_setting;
    }
}
