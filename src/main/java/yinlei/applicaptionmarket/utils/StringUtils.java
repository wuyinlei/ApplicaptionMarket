package yinlei.applicaptionmarket.utils;

import android.content.Context;

/**
 * 字符串工具类
 */
public class StringUtils {

  public static void copy(Context mContext, String stripped) {
    int sdk = android.os.Build.VERSION.SDK_INT;
    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
      android.text.ClipboardManager clipboard =
          (android.text.ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
      clipboard.setText(stripped);
    } else {
      android.content.ClipboardManager clipboard =
          (android.content.ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
      android.content.ClipData clip = android.content.ClipData.newPlainText("content", stripped);
      clipboard.setPrimaryClip(clip);
    }
    ToastUtils.showToast("复制成功");
  }
}
