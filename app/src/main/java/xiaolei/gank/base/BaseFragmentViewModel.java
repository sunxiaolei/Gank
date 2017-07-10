package xiaolei.gank.base;

/**
 * Created by sunxl8 on 2017/7/10.
 */

public abstract class BaseFragmentViewModel {

    protected BaseFragment mFragment;

    public BaseFragmentViewModel(BaseFragment fragment) {
        mFragment = fragment;
    }
}
