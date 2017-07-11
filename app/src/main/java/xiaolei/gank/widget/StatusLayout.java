package xiaolei.gank.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import xiaolei.gank.R;

/**
 * Created by sun on 2017/6/26.
 */

public class StatusLayout extends FrameLayout {

    private TextView tvError;
    private ShimmerTextView stvLoading;

    private Shimmer shimmer;

    private boolean isContentShowing = false;

    public StatusLayout(@NonNull Context context) {
        super(context);
    }

    public StatusLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        tvError = new TextView(getContext());
        tvError.setText("ERROR!!!");
        tvError.setGravity(Gravity.CENTER);
        shimmer = new Shimmer();
        shimmer.setDuration(2000)
                .setDirection(Shimmer.ANIMATION_DIRECTION_RTL);
        stvLoading = new ShimmerTextView(context);
        stvLoading.setText(context.getString(R.string.app_name));
        stvLoading.setReflectionColor(Color.WHITE);
        stvLoading.setTextColor(context.getResources().getColor(R.color.colorTextGray));
        stvLoading.setTextSize(20);
        stvLoading.setGravity(Gravity.CENTER);
        addView(stvLoading);
        addView(tvError);
    }

    public void hideViews() {
        shimmer.cancel();
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof SwipeRefreshLayout) {
                ((SwipeRefreshLayout) getChildAt(i)).setRefreshing(false);
            }
            getChildAt(i).setVisibility(View.GONE);
        }
        isContentShowing = false;
    }

    public void showError(String msg) {
        hideViews();
        tvError.setVisibility(View.VISIBLE);
        tvError.setText(msg);
    }

    public void showLoading() {
        boolean show = true;
        shimmer.cancel();
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof SwipeRefreshLayout) {
                show = false;
            }
            getChildAt(i).setVisibility(View.GONE);
        }
        if (show) {
            stvLoading.setVisibility(View.VISIBLE);
            shimmer.start(stvLoading);
        }
    }

    public void showContent() {
        if (!isContentShowing) {
            hideViews();
        }
        for (int i = 0; i < getChildCount(); i++) {
            if (isContentView(getChildAt(i))) {
                if (getChildAt(i) instanceof SwipeRefreshLayout) {
                    ((SwipeRefreshLayout) getChildAt(i)).setRefreshing(false);
                }
                getChildAt(i).setVisibility(View.VISIBLE);
                isContentShowing = true;
                continue;
            }
        }
    }

    private boolean isContentView(View view) {
        if ((view != null && view != tvError
                && view != stvLoading)) {
            return true;
        }
        return false;
    }


}
