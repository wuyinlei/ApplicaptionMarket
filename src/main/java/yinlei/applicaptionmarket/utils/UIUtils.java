package yinlei.applicaptionmarket.utils;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import yinlei.applicaptionmarket.common.MyApplication;

/**
 * Created by wuyin on 2016/5/2.
 */
public class UIUtils {

    /**
     * 获取到xml中的字符数组
     *
     * @param tab_names 字符数组的ID
     * @return
     */
    public static String[] getStringArray(int tab_names) {
        return getResources().getStringArray(tab_names);
    }

    /**
     * 获取getResources()
     *
     * @return
     */
    private static Resources getResources() {
        return MyApplication.getApplication().getResources();
    }


    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */

    public static int px2dip(int px) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 获取上下文
     *
     * @return
     */
    public static Context getContext() {
        return MyApplication.getApplication();
    }
/*
    *//**
     * 把Runnable 方法提交到主线程运行
     *
     * @param runnable
     *//*
    public static void runOnUiThread(Runnable runnable) {
        // 在主线程运行
        if (android.os.Process.myTid() == MyApplication.getMainTid()) {
            runnable.run();
        } else {
            //获取handler
            BaseApplication.getmHandler().post(runnable);
        }
    }*/

    /**
     * 隐藏键盘
     *
     * @param context
     */
    public static void hideKeyBoard(Activity context) {
        View view = context.getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromInputMethod(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        /*(InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)
                    .hideSoftInputFromInputMethod(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }*/
    }


}
