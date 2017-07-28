package xiaolei.gank.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.tencent.smtt.sdk.WebView;

/**
 * Created by sunxl8 on 2017/7/28.
 */

public class RefreshWebView extends WebView {

    private SwipeRefreshLayout mRefreshLayout;

    public RefreshWebView(Context context) {
        super(context);
    }

    public RefreshWebView(Context context, AttributeSet set) {
        super(context, set);
    }

    public void setRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        mRefreshLayout = swipeRefreshLayout;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mRefreshLayout != null) {
            if (this.getView().getScrollY() == 0) {
                mRefreshLayout.setEnabled(true);
            } else {
                mRefreshLayout.setEnabled(false);
            }
        }
    }
}
