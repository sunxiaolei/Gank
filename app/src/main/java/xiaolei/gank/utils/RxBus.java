package xiaolei.gank.utils;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import xiaolei.gank.net.SchedulersCompat;

/**
 * Created by sunxl8 on 2017/6/27.
 */

public class RxBus {

    private final FlowableProcessor<Object> bus;

    private RxBus() {
        bus = PublishProcessor.create().toSerialized();
    }

    public static RxBus getDefault() {
        return RxBusHolder.sInstance;
    }

    private static class RxBusHolder {
        private static final RxBus sInstance = new RxBus();
    }


    public void post(Object o) {
        bus.onNext(o);
    }

    public <T> Flowable<T> toFlowable(Class<T> eventType) {
        return bus.ofType(eventType);
    }

    public <T> Disposable toDefaultFlowable(Class<T> eventType, Consumer<T> act) {
        return bus.ofType(eventType).compose(SchedulersCompat.applyIoSchedulers()).subscribe(act);
    }
}
