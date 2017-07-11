package xiaolei.gank.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;


/**
 * Created by sunxl8 on 2017/6/23.
 * <p>
 * Fragment基类
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends RxFragment {

    protected abstract int setContentViewId();

    protected abstract void init();

    protected T mBinding;

    protected boolean isVisible;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(setContentViewId(), container, false);
        mBinding = DataBindingUtil.bind(view);
        init();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
        } else {
            isVisible = false;
        }
    }

    public abstract void showLoading();

    public abstract void showContent();

    public abstract void showError(String msg);

    public abstract void showEmpty();

}
