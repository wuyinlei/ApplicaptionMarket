package yinlei.applicaptionmarket.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;

public class DetailActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public static void startActivity(Context mContext, String fid, String tid, String pid, int page) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra("fid", fid);
        intent.putExtra("tid", tid);
        intent.putExtra("pid", pid);
        intent.putExtra("page", page);
        mContext.startActivity(intent);
    }
}
