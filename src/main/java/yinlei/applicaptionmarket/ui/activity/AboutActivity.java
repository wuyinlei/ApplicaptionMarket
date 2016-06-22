package yinlei.applicaptionmarket.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;
import yinlei.applicaptionmarket.ui.fragment.BrowserFragment;
import yinlei.applicaptionmarket.utils.StringUtils;

public class AboutActivity extends BaseAppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private String url;

    private BrowserFragment mFragment;

    @Override
    public int initContentView() {
        return R.layout.activity_about;
    }

    @Override
    protected void initUiAndListener() {
        ButterKnife.bind(this);
        initToolBar(mToolbar);
        url = getIntent().getStringExtra("url");
        mFragment = BrowserFragment
                .newInstance(url, "", getIntent().getBooleanExtra("external", true));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    public static void startActivity(Context mContext, String url, boolean external) {
        Intent intent = new Intent(mContext, AboutActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("external", external);
        mContext.startActivity(intent);
    }

    public static void startActivity(Context mContext, String url) {
        startActivity(mContext, url, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.removeGroup(R.id.browser);
        getMenuInflater().inflate(R.menu.menu_browser, menu);

        String shareContent = String.format("%s %s ", getTitle() + "", url + "");
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareContent);

        MenuItem shareItem = menu.findItem(R.id.share);
        ShareActionProvider shareProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        shareProvider.setShareHistoryFileName("channe_share.xml");
        shareProvider.setShareIntent(shareIntent);

        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() ==android.R.id.home){
            finish();
            return true;
        }
        if (item.getItemId() == R.id.refresh) {
            if (mFragment != null) {
               // mFragment.reload();
                Toast.makeText(this, "刷新", Toast.LENGTH_SHORT).show();
            }
        } else if (item.getItemId() == R.id.copy) {
            StringUtils.copy(this, url);
        } else if (item.getItemId() == R.id.to_browser) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(url);
                intent.setData(content_url);
                startActivity(intent);
            } catch (Exception e) {
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
