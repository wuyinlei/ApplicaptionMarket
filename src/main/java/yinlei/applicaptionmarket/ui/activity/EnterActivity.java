package yinlei.applicaptionmarket.ui.activity;

import android.text.TextUtils;

import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.common.AppConstant;
import yinlei.applicaptionmarket.common.MyApplication;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;
import yinlei.applicaptionmarket.utils.SharedPreferencesUtils;

public class EnterActivity extends BaseAppCompatActivity {



    @Override
    protected void initUiAndListener() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public int initContentView() {
        return 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isFinishing()) {
            return;
        }
        String versionShared = SharedPreferencesUtils.getString(this, AppConstant.GUIDE_SHOW);
        String versionName = MyApplication.getApplication().getVersion();
        if (TextUtils.isEmpty(versionShared) || !versionShared.equalsIgnoreCase(versionName)) {
            //显示引导页
            openActivity(GuideActivity.class);
        } else {
            //显示主界面
            openActivity(MainActivity.class);
        }
        finish();
    }
}
