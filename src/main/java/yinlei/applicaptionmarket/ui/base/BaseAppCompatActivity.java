package yinlei.applicaptionmarket.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.Window;

import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.common.AppManager;

/**
 * AppCompatActivity基类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: BaseAppCompatActivity.java
 * @author: 若兰明月
 * @date: 2016-06-09 18:45
 */

public class BaseAppCompatActivity extends FragmentActivity {

    /**记录日志的标记*/
    private String TAG = BaseAppCompatActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //不要标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //每次打开一个activity的时候添加到Activity栈中，方便Activity的管理
        AppManager.getInstance().addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //当当前Activity销毁的时候调用
        AppManager.getInstance().finishActivity(this);
    }

    /**打开activity*/
    protected void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    /**打开activity并传递bundle数据*/
    protected void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    protected void openActivityWithOutAnim(Class<?> pClass) {
        openActivityWithOutAnim(pClass, null);
    }

    protected void openActivityWithOutAnim(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
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
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }


}
