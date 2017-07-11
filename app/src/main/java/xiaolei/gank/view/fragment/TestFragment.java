package xiaolei.gank.view.fragment;

import xiaolei.gank.R;
import xiaolei.gank.base.BaseFragment;
import xiaolei.gank.databinding.FragmentTestBinding;
import xiaolei.gank.vm.TestViewModel;

/**
 * Created by sunxl8 on 2017/7/10.
 */

public class TestFragment extends BaseFragment<FragmentTestBinding> {

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void init() {
        TestViewModel vm = new TestViewModel(this);
        mBinding.setVm(vm);
        vm.getData();
    }

    @Override
    public void showLoading() {
        mBinding.layoutStatus.showLoading();
    }

    @Override
    public void showContent() {
        mBinding.layoutStatus.showContent();
    }

    @Override
    public void showError(String msg) {
        mBinding.layoutStatus.showError(msg);
    }

    @Override
    public void showEmpty() {
    }
}
