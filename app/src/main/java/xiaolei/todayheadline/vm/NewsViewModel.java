package xiaolei.todayheadline.vm;

import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import xiaolei.todayheadline.databinding.FragmentNewsBinding;
import xiaolei.todayheadline.net.ToutiaoRequst;
import xiaolei.todayheadline.view.adapter.NewsAdapter;
import xiaolei.todayheadline.widget.StatusLayout;

/**
 * Created by sunxl8 on 2017/6/26.
 */

public class NewsViewModel {

    private NewsAdapter mAdapter;
    private FragmentNewsBinding mBinding;

    public NewsViewModel(NewsAdapter adapter,FragmentNewsBinding binding) {
        mAdapter = adapter;
        mBinding = binding;
    }

    public void requestData(String type) {
        mBinding.layoutStatus.setStatus(StatusLayout.STATUS.LOADING);
        Map<String, String> params = new HashMap<>();
        params.put("source", "2");
        params.put("category", type);
        params.put("as", "A1D5D87595C3287");
        ToutiaoRequst.getNews(params)
                .subscribe(dto -> {
                    mBinding.layoutStatus.setStatus(StatusLayout.STATUS.NORMAL);
                    mAdapter.addData(dto.getData());
                }, throwable -> {
                    mBinding.layoutStatus.setStatus(StatusLayout.STATUS.ERROR);
                });
    }
}
