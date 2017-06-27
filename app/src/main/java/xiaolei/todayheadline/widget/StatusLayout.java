package xiaolei.todayheadline.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import xiaolei.todayheadline.R;

/**
 * Created by sun on 2017/6/26.
 */

public class StatusLayout extends FrameLayout {

    public enum STATUS {NORMAL, ERROR, EMPTY, LOADING}

    private TextView tvError;
    private ShimmerTextView stvLoading;

    private Shimmer shimmer;

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

    public void setStatus(STATUS status, String msg) {
        hideViews();
        switch (status) {
            case EMPTY:
                break;
            case ERROR:
                showError(msg);
                break;
            case LOADING:
                showLoading();
                break;
            case NORMAL:
                showNormal();
                break;
        }
    }


    public void setStatus(STATUS status) {
        setStatus(status, "");
    }

    private void hideViews() {
        shimmer.cancel();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
    }

    private void showError(String msg) {
        tvError.setVisibility(View.VISIBLE);
        tvError.setText(msg);
    }

    private void showLoading() {
        stvLoading.setVisibility(View.VISIBLE);
        shimmer.start(stvLoading);
    }

    private void showNormal() {
        for (int i = 0; i < getChildCount(); i++) {
            if (isNormalView(getChildAt(i))) {
                getChildAt(i).setVisibility(View.VISIBLE);
                continue;
            }
        }
    }

    private boolean isNormalView(View view) {
        if ((view != null && view != tvError
                && view != stvLoading)) {
            return true;
        }
        return false;
    }


}
