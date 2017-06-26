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

/**
 * Created by sun on 2017/6/26.
 */

public class StatusLayout extends FrameLayout {

    public enum STATUS{NORMAL,ERROR,EMPTY,LOADING}

    private TextView tvError,tvLoading;

    public StatusLayout(@NonNull Context context) {
        super(context);
    }

    public StatusLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        tvError = new TextView(getContext());
        tvError.setText("ERROR!!!");
        tvLoading = new TextView(getContext());
        tvLoading.setText("LOADING...");
        tvLoading.setGravity(Gravity.CENTER);
        addView(tvLoading);
        addView(tvError);
    }


    public void setStatus(STATUS status){
        hideViews();
        switch (status){
            case EMPTY:
                break;
            case ERROR:
                showError();
                break;
            case LOADING:
                showLoading();
                break;
            case NORMAL:
                showNormal();
                break;
        }
    }

    private void hideViews(){
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
    }

    private void showError(){
        tvError.setVisibility(View.VISIBLE);
    }

    private void showLoading(){
        tvLoading.setVisibility(View.VISIBLE);
    }

    private void showNormal(){
        for (int i = 0; i < getChildCount(); i++) {
            if (isNormalView(getChildAt(i))){
                getChildAt(i).setVisibility(View.VISIBLE);
                continue;
            }
        }
    }

    private boolean isNormalView(View view){
        if ((view != null&&tvError!=view)){
            return true;
        }
        return false;
    }


}
