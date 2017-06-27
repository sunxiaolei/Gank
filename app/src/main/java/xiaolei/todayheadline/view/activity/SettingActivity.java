package xiaolei.todayheadline.view.activity;

import xiaolei.todayheadline.R;
import xiaolei.todayheadline.base.BaseSwipeActivity;
import xiaolei.todayheadline.databinding.ActivitySettingBinding;
import xiaolei.todayheadline.model.TitleEntity;

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
