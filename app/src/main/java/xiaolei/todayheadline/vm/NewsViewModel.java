package xiaolei.todayheadline.vm;

import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import xiaolei.todayheadline.net.ToutiaoRequst;
import xiaolei.todayheadline.view.adapter.NewsAdapter;

/**
 * Created by sunxl8 on 2017/6/26.
 */

public class NewsViewModel {

    private NewsAdapter mAdapter;

    public NewsViewModel(NewsAdapter adapter) {
        mAdapter = adapter;
    }

    public void requestData(String type) {
        Map<String, String> params = new HashMap<>();
        params.put("source", "2");
        params.put("category", type);
        params.put("as", "A1D5D87595C3287");
        ToutiaoRequst.getNews(params)
                .subscribe(dto -> {
                    mAdapter.addData(dto.getData());
                }, throwable -> Logger.d(throwable));
    }
}
