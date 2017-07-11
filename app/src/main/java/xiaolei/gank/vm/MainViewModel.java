package xiaolei.gank.vm;


import xiaolei.gank.base.BaseActivity;
import xiaolei.gank.base.BaseActivityViewModel;

/**
 * Created by sunxl8 on 2017/6/26.
 */

public class MainViewModel extends BaseActivityViewModel {

    public MainViewModel(BaseActivity activity) {
        super(activity);
    }

    public String[] categories = {"Android", "iOS", "前端", "拓展资源", "休息视频"};

}
