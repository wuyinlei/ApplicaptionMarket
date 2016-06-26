package yinlei.applicaptionmarket.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.widget.Toast;


import java.io.File;

import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.utils.CacheUtils;
import yinlei.applicaptionmarket.utils.SettingPrefUtils;
import yinlei.applicaptionmarket.utils.UIUtils;


public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

    private ListPreference pTextSize;// 字体大小
    private Preference pPicSavePath;// 图片保存路径
    private Preference pClearCache;  //清除缓存
    private Preference pTheme;   //主题颜色
    private ListPreference pSwipeBackEdgeMode;// 手势返回方向

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        //修改字体
        pTextSize = (ListPreference) findPreference("pTextSize");
        pTextSize.setOnPreferenceChangeListener(this);
        setListSetting(Integer.parseInt(prefs.getString("pTextSize", "4")), R.array.txtSizeNum,
                pTextSize);

        //图片缓存地址
        pPicSavePath = findPreference("pPicSavePath");
        pPicSavePath.setOnPreferenceChangeListener(this);
        pPicSavePath.setSummary(
                "/sdcard" + File.separator +
                        SettingPrefUtils.getPicSavePath(UIUtils.getContext()) + File.separator
        );

        //清除内存
        pClearCache = findPreference("pClearCache");
        pClearCache.setOnPreferenceChangeListener(this);
        pClearCache.setSummary(CacheUtils.getCacheSize(UIUtils.getContext()));

        //手势返回
        pSwipeBackEdgeMode = (ListPreference) findPreference("pSwipeBackEdgeMode");
        pSwipeBackEdgeMode.setOnPreferenceChangeListener(this);
        setListSetting(Integer.parseInt(prefs.getString("pSwipeBackEdgeMode", "0")), R.array.swipeBackEdgeMode
                , pSwipeBackEdgeMode);

        //主题
        pTheme = findPreference("pTheme");
        pTheme.setOnPreferenceChangeListener(this);
        pTheme.setSummary(getResources().getStringArray(R.array.mdColorNames)[SettingPrefUtils.getThemeIndex(UIUtils.getContext())]);


    }

    protected void setListSetting(int value, int hintId, ListPreference listPreference) {
        String[] valueTitleArr = getResources().getStringArray(hintId);
        listPreference.setSummary(valueTitleArr[value]);
    }

    /**
     * 清理缓存
     */
    private void cleanCache() {
        //        new MaterialDialog.Builder(getActivity()).title("提示").content("正在清空缓存...").progress(true,0).show();
        CacheUtils.cleanApplicationCache(UIUtils.getContext());
        Toast.makeText(getActivity(), "缓存清理成功", Toast.LENGTH_SHORT);
        pClearCache.setSummary(CacheUtils.getCacheSize(UIUtils.getContext()));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if ("pTextSize".equals(preference.getKey())) {
            setListSetting(Integer.parseInt(newValue.toString()), R.array.txtSizeNum, pTextSize);
        } else if ("pSwipeBackEdgeMode".equals(preference.getKey())) {
            setListSetting(Integer.parseInt(newValue.toString()), R.array.swipeBackEdgeMode, pSwipeBackEdgeMode);
        }
        return true;
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if ("pPicSavePath".equals(preference.getKey())) {
            modifyImageSavePath();
        } else if ("pClearCache".equals(preference.getKey())) {
            cleanCache();
        } else if ("pTheme".equals(preference.getKey())) {
            // ColorsDialogFragment.launch(getActivity());
        }
        return true;
    }

    private void modifyImageSavePath() {
        /*new AlertDialog.Builder(getActivity()).title("修改图片保存路径")
                .input(null, SettingPrefUtils.getPicSavePath(UIUtils.getContext()), new MaterialDialog.InputCallback() {
                    @Override public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {
                        if (TextUtils.isEmpty(charSequence)) {
                            ToastUtils.showToast("路径不能为空");
                            return;
                        }
                        String path =
                                FileUtils.getSdcardPath() + File.separator + charSequence + File.separator;
                        File file = new File(path);
                        if (file.exists() || file.mkdirs()) {
                            SettingPrefUtils.setPicSavePath(UIUtils.getContext(), charSequence.toString());
                            pPicSavePath.setSummary("/sdcard" + File.separator + charSequence + File.separator);
                            ToastUtils.showToast("更新成功");
                        } else {
                            ToastUtils.showToast("更新失败");
                        }
                    }
                })
                .negativeText("取消")
                .show();
    }*/
    }
}
