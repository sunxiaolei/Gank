package xiaolei.todayheadline.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import xiaolei.todayheadline.R;
import xiaolei.todayheadline.databinding.ActivityTestBinding;
import xiaolei.todayheadline.model.TestEntity;

public class TestActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        TestEntity entity = new TestEntity();
        entity.setStrTest("Hello MVVM");
        entity.setVisible(true);
        binding.setTest(entity);


        Flowable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aLong -> entity.setStrTest("Im changed!"));
    }
}
