package xiaolei.gank.view.activity;

import xiaolei.gank.R;
import xiaolei.gank.base.BaseSwipeActivity;
import xiaolei.gank.databinding.ActivityTestBinding;
import xiaolei.gank.vm.TestViewModel;

public class TestActivity extends BaseSwipeActivity<ActivityTestBinding> {


    @Override
    protected int setContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    protected void init() {
        TestViewModel vm = new TestViewModel();
        mBinding.setVm(vm);
        mBinding.btnRequest.setOnClickListener(v -> vm.requestData());
    }
}
