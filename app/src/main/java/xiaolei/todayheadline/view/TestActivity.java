package xiaolei.todayheadline.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import xiaolei.todayheadline.R;
import xiaolei.todayheadline.databinding.ActivityTestBinding;
import xiaolei.todayheadline.vm.TestViewModel;

public class TestActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init(){
        ActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        TestViewModel vm = new TestViewModel();
        binding.setVm(vm);
        binding.btnRequest.setOnClickListener(v -> vm.requestData());
    }
}
