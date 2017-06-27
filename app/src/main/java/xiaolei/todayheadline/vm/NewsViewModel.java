package xiaolei.todayheadline.vm;

import java.util.HashMap;
import java.util.Map;

import xiaolei.todayheadline.event.ViewStatusEvent;
import xiaolei.todayheadline.net.ToutiaoRequst;
import xiaolei.todayheadline.utils.RxBus;
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
                    RxBus.getDefault().post(new ViewStatusEvent(ViewStatusEvent.STATUS_NORMAL));
                    mAdapter.addData(dto.getData());
                }, throwable -> {
                    RxBus.getDefault().post(new ViewStatusEvent(ViewStatusEvent.STATUS_ERROR, throwable.getMessage()));
                });
    }
}
