package yinlei.applicaptionmarket.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 吐司工具类
 */
public class ToastUtils {

  public static Context mContext;

  private ToastUtils() {
  }

  public static void register(Context context) {
    mContext = context.getApplicationContext();
  }

  public static void showToast(int resId) {
    Toast.makeText(mContext, mContext.getString(resId), Toast.LENGTH_SHORT).show();
  }

  public static void showToast(String msg) {
    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
  }
}
