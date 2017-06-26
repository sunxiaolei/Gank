package xiaolei.todayheadline.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import xiaolei.todayheadline.R;
import xiaolei.todayheadline.base.BaseActivity;
import xiaolei.todayheadline.base.BaseSwipeActivity;
import xiaolei.todayheadline.databinding.ActivityTestBinding;
import xiaolei.todayheadline.vm.TestViewModel;

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
