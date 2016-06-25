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

        /*WebSettings webSettings =  mWebView .getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
            mProgress.setProgress(newProgress);
                if (newProgress == 100){
                    mProgress.setVisibility(View.GONE);
                } else {
                    mProgress.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (!TextUtils.isEmpty(BrowserFragment.this.title)){
                    //getActivity().setTitle(BrowserFragment.this.title);

                }
            }
        });
        if (external){
            mWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url != null){
                        if (BuildConfig.DEBUG) Log.d("BrowserFragment", url);
                        view.loadUrl(url);
                    }
                    return true;
                }
            });
        }
*/
    }

    @Override
    public void initData() {
        //mWebView.loadUrl(url);
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
