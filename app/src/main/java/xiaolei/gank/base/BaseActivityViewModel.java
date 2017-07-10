package xiaolei.gank.base;

import android.databinding.ViewDataBinding;

/**
 * Created by sunxl8 on 2017/7/10.
 */

public abstract class BaseActivityViewModel {

    protected BaseActivity mActivity;

    public BaseActivityViewModel(BaseActivity activity) {
        mActivity = activity;
    }
}
