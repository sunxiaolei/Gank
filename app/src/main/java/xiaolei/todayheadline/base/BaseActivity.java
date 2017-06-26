package xiaolei.todayheadline.base;

import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by sunxl8 on 2017/6/23.
 * <p>
 * Activity基类
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends RxAppCompatActivity {

    protected abstract int setContentViewId();

    protected abstract void init();

    protected T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, setContentViewId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

}
