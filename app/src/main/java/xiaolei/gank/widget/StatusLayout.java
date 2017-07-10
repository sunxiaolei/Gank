package xiaolei.gank.widget;

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

import xiaolei.gank.R;

/**
 * Created by sun on 2017/6/26.
 */

public class StatusLayout extends FrameLayout {

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

    public void hideViews() {
        shimmer.cancel();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
    }

    public void showError(String msg) {
        hideViews();
        tvError.setVisibility(View.VISIBLE);
        tvError.setText(msg);
    }

    public void showLoading() {
        hideViews();
        stvLoading.setVisibility(View.VISIBLE);
        shimmer.start(stvLoading);
    }

    public void showContent() {
        hideViews();
        for (int i = 0; i < getChildCount(); i++) {
            if (isContentView(getChildAt(i))) {
                getChildAt(i).setVisibility(View.VISIBLE);
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
