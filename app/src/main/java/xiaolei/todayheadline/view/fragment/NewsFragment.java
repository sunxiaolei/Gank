package xiaolei.todayheadline.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import xiaolei.todayheadline.R;
import xiaolei.todayheadline.base.BaseFragment;
import xiaolei.todayheadline.databinding.FragmentNewsBinding;
import xiaolei.todayheadline.view.adapter.NewsAdapter;
import xiaolei.todayheadline.vm.NewsViewModel;

/**
 * Created by sunxl8 on 2017/6/26.
 */

public class NewsFragment extends BaseFragment<FragmentNewsBinding> {

    private NewsViewModel mVm;
    private NewsAdapter mAdapter;

    public static NewsFragment getInstance(String newsType) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", newsType);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void init() {
        String type = getArguments().getString("type");
        mAdapter = new NewsAdapter();
        mVm = new NewsViewModel(mAdapter);
        mBinding.rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.rvNews.setAdapter(mAdapter);

        mVm.requestData(type);
    }
}
