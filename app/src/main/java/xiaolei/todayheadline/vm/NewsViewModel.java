package xiaolei.todayheadline.vm;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.HashMap;
import java.util.Map;

import sunxl8.myutils.ToastUtils;
import xiaolei.todayheadline.event.ViewStatusEvent;
import xiaolei.todayheadline.net.ToutiaoRequst;
import xiaolei.todayheadline.utils.RxBus;
import xiaolei.todayheadline.view.adapter.NewsAdapter;

/**
 * Created by sunxl8 on 2017/6/26.
 */

public class NewsViewModel {

    private NewsAdapter mAdapter;

    private String type;
    private String maxBehotTime;

    public NewsViewModel(NewsAdapter adapter) {
        mAdapter = adapter;
        mAdapter.setOnLoadMoreListener(() -> loadmoreData());
    }

    public void refreshData(String type) {
        this.type = type;
        Map<String, String> params = new HashMap<>();
        params.put("category", type);
        params.put("as", "A1D5D87595C3287");
        ToutiaoRequst.getNews(params)
                .subscribe(dto -> {
                    mAdapter.setNewData(dto.getData());
                    if (dto.isHas_more()) {
                        maxBehotTime = dto.getNext().getMax_behot_time();
                        mAdapter.loadMoreComplete();
                    } else {
                        mAdapter.loadMoreEnd();
                    }
                    RxBus.getDefault().post(new ViewStatusEvent(ViewStatusEvent.STATUS_NORMAL));
                }, throwable -> {
                    RxBus.getDefault().post(new ViewStatusEvent(ViewStatusEvent.STATUS_ERROR, throwable.getMessage()));
                });
    }

    public void loadmoreData() {
        Map<String, String> params = new HashMap<>();
        params.put("category", type);
        params.put("as", "A1D5D87595C3287");
        params.put("max_behot_time", maxBehotTime);
        ToutiaoRequst.getNews(params)
                .subscribe(dto -> {
                    if (dto.isHas_more()) {
                        maxBehotTime = dto.getNext().getMax_behot_time();
                        mAdapter.loadMoreComplete();
                    } else {
                        mAdapter.loadMoreEnd();
                    }
                    mAdapter.addData(dto.getData());
                }, throwable -> {
                    mAdapter.loadMoreFail();
                });
    }
}
