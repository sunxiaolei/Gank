package xiaolei.gank.vm;


import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import xiaolei.gank.base.BaseFragment;
import xiaolei.gank.base.BaseFragmentViewModel;
import xiaolei.gank.net.SchedulersCompat;

/**
 * Created by sun on 2017/6/22.
 */

public class TestViewModel extends BaseFragmentViewModel {

    public TestViewModel(BaseFragment fragment) {
        super(fragment);
    }

    public void getData() {
        mFragment.showLoading();
        Flowable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(mFragment.bindUntilEvent(FragmentEvent.DESTROY))
                .compose(SchedulersCompat.applyIoSchedulers())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        mFragment.showContent();
                    }
                });
    }
}
