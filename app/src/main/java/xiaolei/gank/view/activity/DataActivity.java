package xiaolei.gank.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import sunxl8.myutils.NetworkUtils;
import xiaolei.gank.R;
import xiaolei.gank.base.BaseSwipeActivity;
import xiaolei.gank.databinding.ActivityDataBinding;
import xiaolei.gank.model.GankItemEntity;
import xiaolei.gank.model.TitleEntity;
import xiaolei.gank.vm.DataViewModel;

/**
 * Created by sunxl8 on 2017/7/12.
 */

public class DataActivity extends BaseSwipeActivity<ActivityDataBinding> {

    private GankItemEntity entity;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_data;
    }

    @Override
    protected void init() {
        entity = (GankItemEntity) getIntent().getSerializableExtra("entity");

        mBinding.toolbar.setTitle(new TitleEntity(entity.getDesc()));

        DataViewModel vm = new DataViewModel(this);
        mBinding.setVm(vm);

        mBinding.layoutRefresh.setOnRefreshListener(() -> mBinding.web.reload());

        WebSettings settings = mBinding.web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        if (NetworkUtils.isConnected()) {
            settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        } else {
            settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        String cacheDirPath = getFilesDir().getAbsolutePath() + "/netcache";
        settings.setAppCachePath(cacheDirPath);

        mBinding.web.canGoBack();
        mBinding.web.canGoForward();

        mBinding.web.loadUrl(entity.getUrl());
        mBinding.web.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showLoading();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                showContent();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mBinding.web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {

            }
        });
    }

    @Override
    public void showLoading() {
        mBinding.layoutStatus.showLoading();
    }

    @Override
    public void showContent() {
        mBinding.layoutStatus.showContent();
    }

    @Override
    public void showError(String msg) {
        mBinding.layoutStatus.showError(msg, v -> mBinding.web.loadUrl(entity.getUrl()));
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mBinding.web.canGoBack()) {
            mBinding.web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static void startActivity(Context context, GankItemEntity entity) {
        Intent intent = new Intent(context, DataActivity.class);
        intent.putExtra("entity", entity);
        context.startActivity(intent);
    }
}
