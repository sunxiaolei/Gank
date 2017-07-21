package xiaolei.gank.view.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.KeyEvent;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import sunxl8.myutils.ToastUtils;
import xiaolei.gank.R;
import xiaolei.gank.base.BaseActivity;
import xiaolei.gank.databinding.ActivityMainBinding;
import xiaolei.gank.events.KeyDownEvent;
import xiaolei.gank.events.ListStatusEvent;
import xiaolei.gank.net.SchedulersCompat;
import xiaolei.gank.utils.RxBus;
import xiaolei.gank.view.fragment.DataListFragment;
import xiaolei.gank.view.fragment.TestFragment;
import xiaolei.gank.vm.MainViewModel;

/**
 * Created by sunxl8 on 2017/6/26.
 * <p>
 * 主页
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private MainViewModel mVm;
    private List<Fragment> mFragments;

    private int mListStatus;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        //标题
        mBinding.tvTitle.setText(getResources().getString(R.string.app_name));
        //设置
        RxView.clicks(mBinding.ivSetting)
                .subscribe(o -> {
                    startActivity(new Intent(this, SettingActivity.class));
                });
        mVm = new MainViewModel(this);
        mBinding.setVm(mVm);
        mFragments = new ArrayList<>();
        for (int i = 0; i < mVm.categories.length; i++) {
            mFragments.add(DataListFragment.newInstance(mVm.categories[i]));
        }

        mBinding.vpMain.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), mFragments));
        mBinding.tabMain.setTabMode(TabLayout.MODE_SCROLLABLE);
        mBinding.tabMain.setupWithViewPager(mBinding.vpMain);

        RxBus.getDefault().toFlowable(ListStatusEvent.class)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(event -> mListStatus = event.getStatus());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }

    class MainFragmentAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> mList;

        public MainFragmentAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return this.mList == null ? 0 : this.mList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mVm.categories[position];
        }
    }

    private boolean exitApp = false;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (mListStatus == ListStatusEvent.TOP) {
                if (exitApp) {
                    finish();
                } else {
                    ToastUtils.shortShow("再按一次退出应用程序");
                    exitApp = true;
                    Flowable.timer(2000, TimeUnit.MILLISECONDS)
                            .compose(SchedulersCompat.applyIoSchedulers())
                            .subscribe(aLong -> exitApp = false);
                }
            } else {
                RxBus.getDefault().post(new KeyDownEvent(KeyDownEvent.KEYCODE_BACK));
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
