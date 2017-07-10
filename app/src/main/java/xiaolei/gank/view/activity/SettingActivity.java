package xiaolei.gank.view.activity;

import xiaolei.gank.R;
import xiaolei.gank.base.BaseSwipeActivity;
import xiaolei.gank.databinding.ActivitySettingBinding;
import xiaolei.gank.model.TitleEntity;

/**
 * Created by sunxl8 on 2017/6/27.
 */

public class SettingActivity extends BaseSwipeActivity<ActivitySettingBinding> {

    @Override
    protected int setContentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {
        mBinding.toolbar.setTitle(new TitleEntity("设置"));
    }
}
