package xiaolei.gank.vm;

import xiaolei.gank.base.BaseFragment;
import xiaolei.gank.base.BaseFragmentViewModel;
import xiaolei.gank.net.ErrorHanding;
import xiaolei.gank.net.GankRequest;
import xiaolei.gank.view.adapter.DataAdapter;

/**
 * Created by sunxl8 on 2017/7/11.
 */

public class DataListViewModel extends BaseFragmentViewModel {

    private DataAdapter mAdapter;
    private int page;

    public DataListViewModel(BaseFragment fragment, DataAdapter adapter) {
        super(fragment);
        mAdapter = adapter;
    }

    public void getData(boolean isRefresh, String category) {
        if (isRefresh) {
            mFragment.showLoading();
            page = 1;
        }
        GankRequest.getData(category, 10, page)
                .subscribe(list -> {
                    mFragment.showContent();
                    if (isRefresh) {
                        mAdapter.setNewData(list.getResults());
                    } else {
                        mAdapter.addData(list.getResults());
                    }
                    mAdapter.loadMoreComplete();
                    page++;
                }, throwable -> {
                    if (isRefresh) {
                        mFragment.showError(ErrorHanding.handleError(throwable));
                    } else {
                        mAdapter.loadMoreFail();
                    }
                });
    }
}
