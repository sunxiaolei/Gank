package xiaolei.todayheadline.vm;

import android.databinding.ObservableField;

import java.util.HashMap;
import java.util.Map;

import xiaolei.todayheadline.net.ToutiaoRequst;

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
        //?source=2&category=类型&as=A1D5D87595C3287
        Map<String,String> params = new HashMap<>();
        params.put("source","2");
        params.put("category","news_hot");
        params.put("as","A1D5D87595C3287");
        ToutiaoRequst.getNews(params)
                .subscribe(s -> content.set(s.toString()),
                        throwable -> content.set(throwable.getMessage()));
    }
}
