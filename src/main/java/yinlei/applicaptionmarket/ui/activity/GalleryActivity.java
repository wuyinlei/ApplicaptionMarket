package yinlei.applicaptionmarket.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;

public class GalleryActivity extends BaseAppCompatActivity {

    public static final int REQUEST_IMAGE = 101;
    public static final String EXTRA_RESULT = "select_result";


    public static void startActivity(Activity mActivity, ArrayList<String> selectImages) {
        Intent intent = new Intent(mActivity, GalleryActivity.class);
        intent.putExtra("selectImages", selectImages);
        mActivity.startActivityForResult(intent, REQUEST_IMAGE);
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
        return R.layout.activity_gallery;
    }
}
