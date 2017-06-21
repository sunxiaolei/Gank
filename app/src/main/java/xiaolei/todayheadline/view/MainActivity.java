package xiaolei.todayheadline.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xiaolei.todayheadline.R;
import xiaolei.todayheadline.databinding.ActivityMainBinding;
import xiaolei.todayheadline.model.TestEntity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        TestEntity entity = new TestEntity();
        entity.setTest("Hello MVVM");
        binding.setTest(entity);
    }
}
