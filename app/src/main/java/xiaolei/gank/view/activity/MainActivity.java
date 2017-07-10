package xiaolei.gank.view.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.ArrayList;
import java.util.List;

import xiaolei.gank.R;
import xiaolei.gank.base.BaseActivity;
import xiaolei.gank.databinding.ActivityMainBinding;
import xiaolei.gank.vm.MainViewModel;

/**
 * Created by sunxl8 on 2017/6/26.
 * <p>
 * 主页
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private MainViewModel mVm;
    private List<Fragment> mFragments;

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
        mVm = new MainViewModel();
        mBinding.setVm(mVm);
        mFragments = new ArrayList<>();

        for (int i = 0; i < mVm.titles.length; i++) {
//            mFragments.add(NewsFragment.getInstance(mVm.types[i]));
        }
        mBinding.vpMain.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), mFragments));
        mBinding.tabMain.setTabMode(TabLayout.MODE_SCROLLABLE);
        mBinding.tabMain.setupWithViewPager(mBinding.vpMain);
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
            return mVm.titles[position];
        }
    }
}
