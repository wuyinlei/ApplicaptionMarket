package yinlei.applicaptionmarket.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.contants.Constants;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;

public class PostActivity extends BaseAppCompatActivity {

    private ArrayList<String> selectImages = new ArrayList<String>();

    private int type;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.etSubject)
    EditText mEtSubject;
    @Bind(R.id.textInputSubject)
    TextInputLayout mTextInputSubject;
    @Bind(R.id.etContent)
    EditText mEtContent;
    @Bind(R.id.textInputContent)
    TextInputLayout mTextInputContent;
    @Bind(R.id.llPics)
    LinearLayout mLlPics;
    @Bind(R.id.scrollView)
    HorizontalScrollView mScrollView;

    /**
     * @param mContext 上下文
     * @param type     类型(操作)
     * @param fid
     * @param tid
     * @param pid
     * @param title    标题
     */
    public static void startActivity(Context mContext, int type, String fid, String tid, String pid,
                                     String title) {
        Intent intent = new Intent(mContext, PostActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("fid", fid);
        intent.putExtra("tid", tid);
        intent.putExtra("pid", pid);
        intent.putExtra("title", title);
        mContext.startActivity(intent);
    }


    @Override
    protected void initUiAndListener() {
        ButterKnife.bind(this);
        initToolBar(mToolbar);
        initPostType();
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    public int initContentView() {
        return R.layout.activity_post;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_post,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_send) {
            send();
        } else if (id == R.id.action_camera) {
            GalleryActivity.startActivity(this, selectImages);
        } else if (id == android.R.id.home) {
            finish();
        }
        return true;
    }

    private void send() {
        //mPresenter.parse(selectImages);
        String content = mEtContent.getText().toString();
        if (type == Constants.TYPE_POST) {
            String title = mEtSubject.getText().toString();
        } else {
        }
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GalleryActivity.REQUEST_IMAGE && resultCode == RESULT_OK) {
            // 获取返回的图片列表
            ArrayList<String> path = data.getStringArrayListExtra(GalleryActivity.EXTRA_RESULT);
            // 处理你自己的逻辑 ....
            selectImages.clear();
            selectImages.addAll(path);
            updatePicsUI();
        }
    }

    private void updatePicsUI() {
        if (selectImages.isEmpty()) {
            mScrollView.setVisibility(View.GONE);
            mLlPics.setVisibility(View.GONE);
        } else {
            mScrollView.setVisibility(View.VISIBLE);
            mLlPics.setVisibility(View.VISIBLE);
            mLlPics.removeAllViews();
            for (String path : selectImages) {
                View itemView = View.inflate(this, R.layout.item_post_pic, null);
                SimpleDraweeView ivPic = (SimpleDraweeView) itemView.findViewById(R.id.ivPic);
                itemView.setTag(path);
                itemView.setOnClickListener(onPictureClickListener);
                ivPic.setImageURI(Uri.fromFile(new File(path)));
                mLlPics.addView(itemView,
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
            }
        }
    }

    // 暂时只支持删除，不支持预览
    View.OnClickListener onPictureClickListener = new View.OnClickListener() {

        @Override public void onClick(View v) {
            final String path = v.getTag().toString();

            new AlertDialog.Builder(PostActivity.this).setMessage("确定删除图片")
                    .setNegativeButton("取消", null)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override public void onClick(DialogInterface dialog, int which) {
                            selectImages.remove(path);
                            for (int i = 0; i < mLlPics.getChildCount(); i++) {
                                View view = mLlPics.getChildAt(i);

                                if (view.getTag().toString().equals(path)) {
                                    mLlPics.removeView(view);
                                    break;
                                }
                            }

                            if (selectImages.isEmpty()) {
                                mScrollView.setVisibility(View.GONE);
                            }
                        }
                    })
                    .show();
        }
    };

    private void initPostType() {
        switch (type) {
            case Constants.TYPE_FEED_BACK:
                setTitle("反馈");
                mEtSubject.setFocusable(false);
                mEtSubject.setFocusableInTouchMode(false);
                mEtSubject.setText("Feedback: TLint For Android");
                mEtSubject.setHint("请输入反馈内容");
                break;
            default:
                break;
        }
    }
}
