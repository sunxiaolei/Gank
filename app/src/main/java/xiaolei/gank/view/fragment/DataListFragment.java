package xiaolei.gank.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import xiaolei.gank.R;
import xiaolei.gank.base.BaseFragment;
import xiaolei.gank.databinding.FragmentDatalistBinding;
import xiaolei.gank.model.GankItemEntity;
import xiaolei.gank.view.activity.DataActivity;
import xiaolei.gank.view.adapter.DataAdapter;
import xiaolei.gank.vm.DataListViewModel;

/**
 * Created by sunxl8 on 2017/7/11.
 */

public class DataListFragment extends BaseFragment<FragmentDatalistBinding> {

    private DataListViewModel vm;
    private DataAdapter mAdapter;

    private String category;

    public static DataListFragment newInstance(String category) {
        Bundle args = new Bundle();
        args.putString("category", category);
        DataListFragment fragment = new DataListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_datalist;
    }

    @Override
    protected void init() {
        category = getArguments().getString("category");
        mAdapter = new DataAdapter();
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mBinding.rvDatalist.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.rvDatalist.setAdapter(mAdapter);
        vm = new DataListViewModel(this, mAdapter);
        mBinding.setVm(vm);

        //下拉刷新 上拉加载
        mBinding.layoutRefresh.setOnRefreshListener(() -> vm.getData(true, category));
        mAdapter.setOnLoadMoreListener(() -> vm.getData(false, category));

        mAdapter.setOnItemClickListener((adapter, view, i) ->
                DataActivity.startActivity(getActivity(), (GankItemEntity) adapter.getItem(i)));

        vm.getData(true, category);
    }

    @Override
    public void showLoading() {
        mBinding.layoutStatus.showLoading();
    }

    @Override
    public void showContent() {
        mBinding.layoutStatus.showContent();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String msg) {
        mBinding.layoutStatus.showError(msg, v -> vm.getData(true, category));
    }

    @Override
    public void showEmpty() {

    }
}
