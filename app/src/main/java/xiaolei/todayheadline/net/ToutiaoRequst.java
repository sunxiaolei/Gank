package xiaolei.todayheadline.net;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by sun on 2017/6/22.
 */

public class ToutiaoRequst {

    public static Flowable<String> getNews(Map<String, String> params) {
        return NetworkManager.getCommonClient(NetConstant.TOUTIAO_BASE_HOST)
                .create(ToutiaoApi.class)
                .getNews(params)
                .compose(SchedulersCompat.applyIoSchedulers());
    }
}
