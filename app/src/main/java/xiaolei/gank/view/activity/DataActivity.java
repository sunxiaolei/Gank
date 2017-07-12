package xiaolei.gank.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        mBinding.layoutStatus.showError(msg);
    }

    @Override
    public void showEmpty() {

    }

    public static void startActivity(Context context, GankItemEntity entity) {
        Intent intent = new Intent(context, DataActivity.class);
        intent.putExtra("entity", entity);
        context.startActivity(intent);
    }
}
