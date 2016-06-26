package yinlei.applicaptionmarket.ui.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import com.thefinestartist.finestwebview.FinestWebView;

import butterknife.Bind;
import butterknife.ButterKnife;
import yinlei.applicaptionmarket.BuildConfig;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.base.BaseFragment;

/**
 *
 */
public class BrowserFragment extends BaseFragment {

    @Bind(R.id.webView)
    WebView mWebView;
    @Bind(R.id.progress)
    ProgressBar mProgress;

    private String url;
    private String title;
    private boolean external;

    @Override
    public void initUI(View view) {
        ButterKnife.bind(this, view);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //String openUrl="http://www.baidu.com";

        //new FinestWebView.Builder(getActivity()).show(url);

    }

    @Override
    public void initData() {
        if (!TextUtils.isEmpty(title)){
            getActivity().setTitle(BrowserFragment.this.title);
        }

        //当用户点击一个webView中的页面的链接时，通常，是由默认的的浏览器打开并加载目标URL的
//然而，你可以在webView中覆盖这一行为,那么链接就会在webView中打开
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //当返回值是true的时候由webView来打开，为false的时候则由第三方或者系统默认的浏览器打开
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.loadUrl(url);
       /* String openUrl="http://www.baidu.com";

        //当用户点击一个webView中的页面的链接时，通常，是由默认的的浏览器打开并加载目标URL的
//然而，你可以在webView中覆盖这一行为,那么链接就会在webView中打开
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //当返回值是true的时候由webView来打开，为false的时候则由第三方或者系统默认的浏览器打开
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.loadUrl(openUrl);
        //new FinestWebView.Builder(getActivity()).show(url);
*/
    }

    @Override
    public void initInjector() {

    }

    @Override
    public void getBundle(Bundle bundle) {
        url = bundle.getString("url");
        title = bundle.getString("title");
        external = bundle.getBoolean("external");
    }

    @Override
    public int initContentView() {
        return R.layout.fragment_browser;
    }

    public static BrowserFragment newInstance(String url, String title) {
        return newInstance(url, title, false);
    }

    public static BrowserFragment newInstance(String url, String title, boolean external) {
        BrowserFragment mFragment = new BrowserFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("title", title);
        bundle.putBoolean("external", external);
        mFragment.setArguments(bundle);
        return mFragment;
    }


}
