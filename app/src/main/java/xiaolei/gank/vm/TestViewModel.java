package xiaolei.gank.vm;

import android.databinding.ObservableField;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sun on 2017/6/22.
 */

public class TestViewModel {

    public final ObservableField<Boolean> showImg =
            new ObservableField<>();
    public final ObservableField<String> content =
            new ObservableField<>();

    public TestViewModel() {
        showImg.set(true);
    }

    public void requestData(){
        showImg.set(false);
    }
}
