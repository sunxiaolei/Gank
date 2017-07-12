package xiaolei.gank.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by sunxl8 on 2017/7/10.
 */

public abstract class BaseActivityViewModel {

    protected AppCompatActivity mActivity;

    public BaseActivityViewModel(AppCompatActivity activity) {
        mActivity = activity;
    }
}
