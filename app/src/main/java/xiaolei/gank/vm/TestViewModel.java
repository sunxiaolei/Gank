package xiaolei.gank.vm;


import android.databinding.ObservableField;

import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import xiaolei.gank.base.BaseFragment;
import xiaolei.gank.base.BaseFragmentViewModel;
import xiaolei.gank.net.GankRequest;
import xiaolei.gank.net.SchedulersCompat;

/**
 * Created by sun on 2017/6/22.
 */

public class TestViewModel extends BaseFragmentViewModel {

    public ObservableField<String> result = new ObservableField<>();

    public TestViewModel(BaseFragment fragment) {
        super(fragment);
    }

    public void getData() {
        mFragment.showLoading();
//        Flowable.timer(2000, TimeUnit.MILLISECONDS)
//                .compose(mFragment.bindUntilEvent(FragmentEvent.DESTROY))
//                .compose(SchedulersCompat.applyIoSchedulers())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(@NonNull Long aLong) throws Exception {
//                        mFragment.showContent();
//                    }
//                });
//        GankRequest.getData("all", 3, 1)
//                .compose(mFragment.bindUntilEvent(FragmentEvent.DESTROY))
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(@NonNull String s) throws Exception {
//                        mFragment.showContent();
//                        result.set(s);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        mFragment.showError(throwable.getMessage());
//                    }
//                });

    }
}
